package com.nexusnimbus.model;

public class SaveProduct {

	private String productName;
	private String productBrand;
	private String productPrice;
	private String productSpecs;
	private String picture;
	public SaveProduct(String productName, String productBrand, String productPrice, String productSpecs) {
		
		this.productName = productName;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productSpecs = productSpecs;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductSpecs() {
		return productSpecs;
	}
	public void setProductSpecs(String productSpecs) {
		this.productSpecs = productSpecs;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}