package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SIMSAdminMainActivity extends Activity {

	private Button btn_1x1;
	private Button btn_1x2;
	private Button btn_1x3;
	private Button btn_2x1;
	private Button btn_2x2;
	private Button btn_2x3;
	private Button btn_3x1;
	private Button btn_4x4;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsadminmainactivity);

		btn_1x1 = (Button) findViewById(R.id.btn_1x1);
		btn_1x2 = (Button) findViewById(R.id.btn_1x2);
		btn_1x3 = (Button) findViewById(R.id.btn_1x3);
		btn_2x1 = (Button) findViewById(R.id.btn_2x1);
		btn_2x2 = (Button) findViewById(R.id.btn_2x2);
		btn_2x3 = (Button) findViewById(R.id.btn_2x3);
		btn_3x1 = (Button) findViewById(R.id.btn_3x1);
		btn_4x4 = (Button) findViewById(R.id.btn_4x4);

		btn_1x1.setOnClickListener(btn1x1AllOnClickListener);
		btn_1x2.setOnClickListener(btn1x2AllOnClickListener);
		btn_1x3.setOnClickListener(btn1x3AllOnClickListener);
		btn_2x1.setOnClickListener(btn2x1AllOnClickListener);
		btn_2x2.setOnClickListener(btn2x2AllOnClickListener);
		btn_2x3.setOnClickListener(btn2x3AllOnClickListener);
		btn_3x1.setOnClickListener(btn3x1AllOnClickListener);
		btn_4x4.setOnClickListener(btn4x4AllOnClickListener);
	}
	
	OnClickListener btn1x1AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsUserAddDelItemIntent = new Intent(view.getContext(), SIMSAdminAddDelItemActivity.class);
            startActivity(simsUserAddDelItemIntent); 
    	}
	};
	
	OnClickListener btn1x2AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsAdminViewItemIntent = new Intent(view.getContext(), SIMSAdminViewItemActivity.class);
            startActivity(simsAdminViewItemIntent); 
    	}
	};
	
	OnClickListener btn1x3AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsAdminViewEmailSalesIntent = new Intent(view.getContext(), SIMSAdminViewEmailSalesActivity.class);
            startActivity(simsAdminViewEmailSalesIntent); 
    	}
	};
	
	OnClickListener btn2x1AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsAdminManageUsersIntent = new Intent(view.getContext(), SIMSAdminManageUsersActivity.class);
            startActivity(simsAdminManageUsersIntent); 
    	}
	};
	
	OnClickListener btn2x2AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsAdminAddStockIntent = new Intent(view.getContext(), SIMSAdminAddStockActivity.class);
            startActivity(simsAdminAddStockIntent); 
    	}
	};
	
	OnClickListener btn2x3AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsAdminViewEmailStockIntent = new Intent(view.getContext(), SIMSAdminViewEmailStockActivity.class);
            startActivity(simsAdminViewEmailStockIntent); 
    	}
	};
	
	OnClickListener btn3x1AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		Intent simsAdminAddPayPalIDIntent = new Intent(view.getContext(), SIMSAdminAddPayPalIDActivity.class);
         	startActivity(simsAdminAddPayPalIDIntent); 
    	}
	};
	
	OnClickListener btn4x4AllOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		finish();
    	}
	};
}
