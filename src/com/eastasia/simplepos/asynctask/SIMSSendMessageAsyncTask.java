package com.eastasia.simplepos.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.eastasia.simplepos.constant.SIMSConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class SIMSSendMessageAsyncTask extends AsyncTask <String, Void, String> {

	private ProgressDialog progressDialog;
	private Context context;

	public SIMSSendMessageAsyncTaskResponse simsSendMessageAsyncTaskDelegate = null;
	
	private String message;
	
	public SIMSSendMessageAsyncTask(Context context, String message) {
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
		//String result = "";
		
		String [] splitArray = params[0].split(";");
		String jsonString = splitArray[0];
		String clientId = splitArray[1];
		String queueName = splitArray[2];
		
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Channel channel = null;

		try {
			connectionFactory = new ConnectionFactory();
			connectionFactory.setHost(SIMSConstant.HOST_NAME);
			connectionFactory.setPort(SIMSConstant.PORT_NO);
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();
			
			channel.queueDeclare(SIMSConstant.ROUTING_KEY, true, false, false, null);
			channel.confirmSelect();
			
			channel.basicPublish(SIMSConstant.EXCHANGE_NAME, SIMSConstant.ROUTING_KEY, 
					true, false, MessageProperties.PERSISTENT_BASIC, jsonString.getBytes());
			
			channel.waitForConfirmsOrDie();
			
			channel.queueDelete(SIMSConstant.ROUTING_KEY);
			
			channel.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    return clientId + ";" + queueName;
    }

    @Override
    protected void onPostExecute(String result) {
    	if (progressDialog != null && progressDialog.isShowing())
    		progressDialog.dismiss();
    	
    	simsSendMessageAsyncTaskDelegate.processSendMessage(result);
    }
    
    public interface SIMSSendMessageAsyncTaskResponse {
    	void processSendMessage(String result);
    }
        
}
