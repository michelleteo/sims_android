package com.eastasia.simplepos.asynctask;

import com.eastasia.simplepos.constant.SIMSConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class SIMSReceiveMessageAsyncTask extends AsyncTask <String, Void, String> {

	private ProgressDialog progressDialog;
	private Context context;
	
	public SIMSReceiveMessageAsyncTaskResponse simsReceiveMessageAsyncTaskDelegate = null;
	
	private String message;
	protected boolean running;
		
	public SIMSReceiveMessageAsyncTask(Context context, String message) {
	    this.context = context;
	    this.message = message;
	}

    @Override
    protected void onPreExecute() {
    	progressDialog = new ProgressDialog(this.context);
    	progressDialog.setMessage(message);
    	progressDialog.setCancelable(false);
    	progressDialog.show();
    }
    
	@Override
	protected String doInBackground(String... params) {
		String result = "";

		String[] splitArray = params[0].split(";");
		String clientId = "*." + splitArray[0];
		String queueName = splitArray[1];
		
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Channel channel = null;
		QueueingConsumer queueingConsumer = null;
		QueueingConsumer.Delivery queueingConsumerDelivery = null;
		
		try {
			connectionFactory = new ConnectionFactory();
			connectionFactory.setHost(SIMSConstant.HOST_NAME);
			connectionFactory.setPort(SIMSConstant.PORT_NO);
			
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(SIMSConstant.EXCHANGE_NAME, SIMSConstant.EXCHANGE_TYPE, true);
			channel.queueDeclare(queueName, true, false, false, null);
			channel.queueBind(queueName, SIMSConstant.EXCHANGE_NAME, clientId);
				
			queueingConsumer = new QueueingConsumer(channel);
			channel.basicConsume(queueName, false, "", false, true, null, queueingConsumer);
			
			running = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		do {
			try {
				queueingConsumerDelivery = queueingConsumer.nextDelivery();
				result = new String(queueingConsumerDelivery.getBody(), "UTF8");
				channel.basicAck(queueingConsumerDelivery.getEnvelope().getDeliveryTag(), false);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while (result.equalsIgnoreCase("") || result == null);

		try {
			channel.close();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

    @Override
    protected void onPostExecute(String result) {
    	if (progressDialog != null && progressDialog.isShowing())
    		progressDialog.dismiss();
    	
    	simsReceiveMessageAsyncTaskDelegate.processReceiveMessage(result);
    }
    
    public interface SIMSReceiveMessageAsyncTaskResponse {
    	void processReceiveMessage(String result);
    }

}
