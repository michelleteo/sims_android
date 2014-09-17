package com.eastasia.simplepos.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class SIMSNetworkDetector {

	private Context context;
    
    public SIMSNetworkDetector(Context context) {
        this.context = context;
    }
    
    public boolean isConnectingTo3GorWireless() {
    	ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    	
    	if (connectivityManager != null)  {
    		NetworkInfo [] networkInfoArray = connectivityManager.getAllNetworkInfo();
             
            if (networkInfoArray != null) 
            	for (int i = 0; i < networkInfoArray.length; i++)
            		if (networkInfoArray[i].getState() == NetworkInfo.State.CONNECTED)
            			return true;
        }
          
    	return false;
    }
    
}
