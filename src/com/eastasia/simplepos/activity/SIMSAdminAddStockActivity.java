package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SIMSAdminAddStockActivity extends Activity {

	private Spinner sp_SelCat;
	private Spinner sp_SelItem;
	private Spinner sp_SelCat1;
	private Spinner sp_SelItem1;
	private Button btn_BackToMain;
	
	private ArrayAdapter <String> sp_SelCatArrayAdapter;
	private ArrayAdapter <String> sp_SelItemArrayAdapter;
	private ArrayAdapter <String> sp_SelCat1ArrayAdapter;
	private ArrayAdapter <String> sp_SelItem1ArrayAdapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsadminaddstockactivity);

		sp_SelCat = (Spinner) findViewById(R.id.sp_selcat);
		sp_SelItem = (Spinner) findViewById(R.id.sp_selitem);
		sp_SelCat1 = (Spinner) findViewById(R.id.sp_selcat1);
		sp_SelItem1 = (Spinner) findViewById(R.id.sp_selitem1);
		btn_BackToMain = (Button) findViewById(R.id.btn_backtomain);
		
		sp_SelCatArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select category"});
		sp_SelItemArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Item"});
		sp_SelCat1ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select category"});
		sp_SelItem1ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Item"});
		
		sp_SelCat.setAdapter(sp_SelCatArrayAdapter);
		sp_SelItem.setAdapter(sp_SelItemArrayAdapter);
		sp_SelCat1.setAdapter(sp_SelCat1ArrayAdapter);
		sp_SelItem1.setAdapter(sp_SelItem1ArrayAdapter);
		
		btn_BackToMain.setOnClickListener(btnBackToMainOnClickListener);
	}

	OnClickListener btnBackToMainOnClickListener = new View.OnClickListener() {
    	@Override
        public void onClick(View view) {
    		finish();
    	}
	};
	
}
