package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SIMSAdminManageUsersActivity extends Activity {

	private Spinner sp_SelUsername;
	private Spinner sp_SelUsername1;
	private Spinner sp_SelUsername2;
	private Button btn_BackToMain;
	
	private ArrayAdapter <String> sp_SelUsernameArrayAdapter;
	private ArrayAdapter <String> sp_SelUsername1ArrayAdapter;
	private ArrayAdapter <String> sp_SelUsername2ArrayAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsadminmanageusersactivity);

		sp_SelUsername = (Spinner) findViewById(R.id.sp_selusername);
		sp_SelUsername1 = (Spinner) findViewById(R.id.sp_selusername1);
		sp_SelUsername2 = (Spinner) findViewById(R.id.sp_selusername2);
		btn_BackToMain = (Button) findViewById(R.id.btn_backtomain);
		
		sp_SelUsernameArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Username"});
		sp_SelUsername1ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Username"});
		sp_SelUsername2ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Username"});
		
		sp_SelUsername.setAdapter(sp_SelUsernameArrayAdapter);
		sp_SelUsername1.setAdapter(sp_SelUsername1ArrayAdapter);
		sp_SelUsername2.setAdapter(sp_SelUsername2ArrayAdapter);
		
		btn_BackToMain.setOnClickListener(btnBackToMainOnClickListener);
	}
	
	OnClickListener btnBackToMainOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		finish();
    	}
	};
	
}
