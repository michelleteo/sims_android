package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SIMSUserMainActivity extends Activity {
	
	private Button btn_Logout;
	//private Button btn_Back;
	//private Button btn_Clear;
	//private Button btn_CashPayment;
	//private Button btn_CCPayment;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsusermainactivity);
		
		btn_Logout = (Button) findViewById(R.id.btn_logout);
		//btn_Back = (Button) findViewById(R.id.btn_back);
		//btn_Clear = (Button) findViewById(R.id.btn_clear);
		//btn_CashPayment = (Button) findViewById(R.id.btn_cashpayment);
		//btn_CCPayment = (Button) findViewById(R.id.btn_ccpayment);
		
		btn_Logout.setOnClickListener(btnLogoutOnClickListener);
	}
	
	OnClickListener btnLogoutOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		finish();
    	}
	};
	
}
