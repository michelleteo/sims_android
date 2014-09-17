package com.eastasia.simplepos.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.eastasia.simplepos.R;
import com.eastasia.simplepos.asynctask.SIMSReceiveMessageAsyncTask;
import com.eastasia.simplepos.asynctask.SIMSSendMessageAsyncTask;
import com.eastasia.simplepos.constant.SIMSConstant;
import com.eastasia.simplepos.json.SIMSJSON;
import com.eastasia.simplepos.utility.SIMSNetworkDetector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SIMSMainLoginActivity extends Activity implements SIMSSendMessageAsyncTask.SIMSSendMessageAsyncTaskResponse, 
															   SIMSReceiveMessageAsyncTask.SIMSReceiveMessageAsyncTaskResponse {

	private SIMSNetworkDetector simsNetworkDetector;
    private SIMSSendMessageAsyncTask simsSendMessageAsyncTask;
	private SIMSReceiveMessageAsyncTask simsReceiveMessageAsyncTask;
	
    private EditText et_Username;
    private EditText et_Password;
	private Button btn_Login;
    private Button btn_ClearAll;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simpleposloginactivity);
	
		et_Username = (EditText) findViewById(R.id.et_username);
		et_Password = (EditText) findViewById(R.id.et_password);
		btn_Login = (Button) findViewById(R.id.btn_login);
		btn_ClearAll = (Button) findViewById(R.id.btn_clearall);
		
		btn_Login.setOnClickListener(btnLoginOnClickListener);
		btn_ClearAll.setOnClickListener(btnClearAllOnClickListener);
		
		simsNetworkDetector = new SIMSNetworkDetector(getApplicationContext());
		
		// Login Credential --> Must take away when go live or show client
		et_Username.setText("admin");
		et_Password.setText("test");
	}
	
	OnClickListener btnLoginOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		if ("".equalsIgnoreCase(et_Username.getText().toString())) {
	    		Toast.makeText(view.getContext(), "Please enter Username", Toast.LENGTH_SHORT).show();
    		} else if ("".equalsIgnoreCase(et_Password.getText().toString())) {
	    		Toast.makeText(view.getContext(), "Please enter Password", Toast.LENGTH_SHORT).show();
    		} else {
    			String clientId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
    			String jsonString = SIMSJSON.getLoginJSON(clientId, et_Username.getText().toString(), et_Password.getText().toString());

    			System.out.println("jsonString: " + jsonString);
    			
        		if (simsNetworkDetector.isConnectingTo3GorWireless()) {
        			simsSendMessageAsyncTask = new SIMSSendMessageAsyncTask(view.getContext(), SIMSConstant.MESSAGE_AUTHENTICATE);
        			simsSendMessageAsyncTask.execute(new String[] { jsonString + ";" + clientId + ";" + SIMSConstant.QUEUE_LOGIN });
        			simsSendMessageAsyncTask.simsSendMessageAsyncTaskDelegate = SIMSMainLoginActivity.this;
        		} else {
    				Toast.makeText(view.getContext(), "Internet Connection Required!", Toast.LENGTH_SHORT).show();
        		}
        	}
    	}
	};
	
	OnClickListener btnClearAllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		et_Username.setText("");
    		et_Password.setText("");
    	}
	};

	@Override
	public void processSendMessage(String result) {
		String clientId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
		
		simsReceiveMessageAsyncTask = new SIMSReceiveMessageAsyncTask(this, SIMSConstant.MESSAGE_AUTHENTICATE);
		simsReceiveMessageAsyncTask.execute(new String[] { clientId + ";" + SIMSConstant.QUEUE_LOGIN });
		simsReceiveMessageAsyncTask.simsReceiveMessageAsyncTaskDelegate = SIMSMainLoginActivity.this;
	}
	
	@Override
	public void processReceiveMessage(String result) {
		try {
			System.out.println("result: " + result);
			JSONObject jsonObject = new JSONObject(result);
			
			int errorCode = jsonObject.getJSONObject("status").getInt("error_code");
			String errorMsg = jsonObject.getJSONObject("status").getString("error_msg");
			
			if (errorCode == 0) {
				int userType = jsonObject.getJSONObject("details").getInt("user_type");
				
				if (userType == 2) {
					Intent simsAdminMainActivityIntent = new Intent(this.getApplicationContext(), SIMSAdminMainActivity.class);
					startActivity(simsAdminMainActivityIntent); 
				} else if (userType == 3) {
					Intent simsUserMainActivityIntent = new Intent(this.getApplicationContext(), SIMSUserMainActivity.class);
					startActivity(simsUserMainActivityIntent); 
				} else {
	    			Toast.makeText(this.getApplicationContext(), "Error: Unknown User Type", Toast.LENGTH_SHORT).show();
				}
			} else {
    			Toast.makeText(this.getApplicationContext(), "Error: " + errorMsg, Toast.LENGTH_SHORT).show();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
