package com.eastasia.simplepos.constant;

public class SIMSConstant {

	public static final String HOST_NAME = "113.11.251.244";
	public static final int PORT_NO = 5672;
	public static final String ROUTING_KEY = "serverv1";
	public static final String EXCHANGE_NAME = "amq.topic";
	public static final String EXCHANGE_TYPE = "topic";
	
	public static final String METHOD_LOGIN = "login";
	public static final String METHOD_CHECK_LOW_STOCKS = "check_low_stocks";
	public static final String METHOD_ADD_CATEGORY = "add_category";
	public static final String METHOD_ADD_ITEM = "add_item";
	
	public static final String QUEUE_LOGIN = "LoginQueue";

	public static final String MESSAGE_AUTHENTICATE = "Authenticating. . .";

}
