package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SIMSAdminViewItemActivity extends Activity {

	private Spinner sp_SelCat;
	private Button btn_BackToMain;
	
	private ArrayAdapter <String> sp_SelCatArrayAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsadminviewitemactivity);
		
		sp_SelCat = (Spinner) findViewById(R.id.sp_selcat);
		btn_BackToMain = (Button) findViewById(R.id.btn_backtomain);
		
		sp_SelCatArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Category"});
		sp_SelCat.setAdapter(sp_SelCatArrayAdapter);
		
		btn_BackToMain.setOnClickListener(btnBackToMainOnClickListener);
	} 
	
	OnClickListener btnBackToMainOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		finish();
    	}
	};
	
}
