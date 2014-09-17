package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SIMSAdminViewEmailStockActivity extends Activity {

	private Spinner sp_SelYear;
	private Spinner sp_SelMth;
	private Spinner sp_SelDay;
	private Button btn_BackToMain;
	
	private ArrayAdapter <String> sp_SelYearArrayAdapter;
	private ArrayAdapter <String> sp_SelMthArrayAdapter;
	private ArrayAdapter <String> sp_SelDayArrayAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsadminviewemailstockactivity);

		sp_SelYear = (Spinner) findViewById(R.id.sp_selyear);
		sp_SelMth = (Spinner) findViewById(R.id.sp_selmth);
		sp_SelDay = (Spinner) findViewById(R.id.sp_selday);
		btn_BackToMain = (Button) findViewById(R.id.btn_backtomain);
		
		sp_SelYearArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Year"});
		sp_SelMthArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Month"});
		sp_SelDayArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Day"});
		
		sp_SelYear.setAdapter(sp_SelYearArrayAdapter);
		sp_SelMth.setAdapter(sp_SelMthArrayAdapter);
		sp_SelDay.setAdapter(sp_SelDayArrayAdapter);
		
		btn_BackToMain.setOnClickListener(btnBackToMainOnClickListener);
	}
	
	OnClickListener btnBackToMainOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		finish();
    	}
	};
}
