package com.eastasia.simplepos.object;

import java.sql.Date;

public class SIMSItemObject {

	private String name;
	private int sku;
	private int category_id;
	private double unit_price;
	private String image_link;
	private Date date_created;
	private Date date_modified;
	private int min_quantity;
	private int quantity;
	
	public SIMSItemObject() {
	}

	public SIMSItemObject(String name, int sku, int category_id,
			double unit_price, String image_link, Date date_created,
			Date date_modified, int min_quantity, int quantity) {
		this.name = name;
		this.sku = sku;
		this.category_id = category_id;
		this.unit_price = unit_price;
		this.image_link = image_link;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.min_quantity = min_quantity;
		this.quantity = quantity;
	}
	
}
