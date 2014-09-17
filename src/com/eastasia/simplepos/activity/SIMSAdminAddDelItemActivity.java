package com.eastasia.simplepos.activity;

import com.eastasia.simplepos.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.Spinner;

public class SIMSAdminAddDelItemActivity extends Activity {

	//private EditText et_AddCatName;
	//private Button btn_AddCat;
	private Spinner sp_SelCat;
	//private EditText et_AddItemName;
	//private EditText et_AddSKUNum;
	//private Button btn_AddItem;
	private Spinner sp_SelCat1;
	private Spinner sp_SelItem;
	//private EditText et_ChgePrice;
	//private EditText et_ChgeImg;
	//private Button btn_ChgePriceImg;
	private Spinner sp_SelCat2;
	//private Button btn_DelCat;
	private Spinner sp_SelCat3;
	private Spinner sp_SelItem1;
	//private Button btn_DelItem;
	private Button btn_BackToMain;
	
	private ArrayAdapter <String> sp_SelCatArrayAdapter;
	private ArrayAdapter <String> sp_SelItemArrayAdapter;
	private ArrayAdapter <String> sp_SelCat1ArrayAdapter;
	private ArrayAdapter <String> sp_SelCat2ArrayAdapter;
	private ArrayAdapter <String> sp_SelCat3ArrayAdapter;
	private ArrayAdapter <String> sp_SelItem1ArrayAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simsadminadddelitemsactivity);
		
		sp_SelCat = (Spinner) findViewById(R.id.sp_selcat);
		sp_SelCat1 = (Spinner) findViewById(R.id.sp_selcat1);
		sp_SelItem = (Spinner) findViewById(R.id.sp_selitem);
		sp_SelCat2 = (Spinner) findViewById(R.id.sp_selcat2);
		sp_SelCat3 = (Spinner) findViewById(R.id.sp_selcat3);
		sp_SelItem1 = (Spinner) findViewById(R.id.sp_selitem1);
		btn_BackToMain = (Button) findViewById(R.id.btn_backtomain);
		
		sp_SelCatArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Category"});
		sp_SelItemArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Item Name"});
		sp_SelCat1ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Category"});
		sp_SelCat2ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Category"});
		sp_SelCat3ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Category"});
		sp_SelItem1ArrayAdapter = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, new String [] {"Select Item"});
		
		sp_SelCat.setAdapter(sp_SelCatArrayAdapter);
		sp_SelItem.setAdapter(sp_SelItemArrayAdapter);
		sp_SelCat1.setAdapter(sp_SelCat1ArrayAdapter);
		sp_SelCat2.setAdapter(sp_SelCat2ArrayAdapter);
		sp_SelCat3.setAdapter(sp_SelCat3ArrayAdapter);
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
