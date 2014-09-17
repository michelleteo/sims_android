package com.eastasia.simplepos.json;

import org.json.simple.JSONObject;

import com.eastasia.simplepos.constant.SIMSConstant;

public class SIMSJSON {

	public static String getLoginJSON(String clientId, String username, String password) {
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
    
		jsonObject2.put("username", username);
		jsonObject2.put("password", password);
		jsonObject1.put("method", SIMSConstant.METHOD_LOGIN);
		jsonObject1.put("message", jsonObject2);
		jsonObject1.put("client_id", clientId);
    	
		return jsonObject1.toJSONString();
	}
	
	public static String getCheckLowStockJSON(String clientId, String companyId) {
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
    
		jsonObject2.put("company_id", companyId);
		jsonObject1.put("method", SIMSConstant.METHOD_CHECK_LOW_STOCKS);
		jsonObject1.put("message", jsonObject2);
		jsonObject1.put("client_id", clientId);
    	
		return jsonObject1.toJSONString();
	}
	
	public static String getAddCategoryJSON(String clientId, String companyId, String categoryName) {
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();

		jsonObject3.put("name", categoryName);
		jsonObject3.put("company_id", companyId);
		jsonObject2.put("details", jsonObject3);
		jsonObject1.put("method", SIMSConstant.METHOD_ADD_CATEGORY);
		jsonObject1.put("message", jsonObject2);
		jsonObject1.put("client_id", clientId);
    	
		return jsonObject1.toJSONString();
	}
	
	public static String getAddItemJSON(String clientId, String itemName, String categoryId, double unitPrice, double minStock, int quantity, int sku) {
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();

		jsonObject3.put("name", itemName);
		jsonObject3.put("categoryId", categoryId);
		jsonObject3.put("unit_price", unitPrice);
		jsonObject3.put("min_stock", minStock);
		jsonObject3.put("quantity", quantity);
		
		if (sku > 0)
			jsonObject3.put("sku", sku);
		
		jsonObject2.put("details", jsonObject3);
		jsonObject1.put("method", SIMSConstant.METHOD_ADD_ITEM);
		jsonObject1.put("message", jsonObject2);
		jsonObject1.put("client_id", clientId);
    	
		return jsonObject1.toJSONString();
	}
	
}
