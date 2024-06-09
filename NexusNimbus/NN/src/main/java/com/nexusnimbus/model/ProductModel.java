package com.nexusnimbus.model;


public class ProductModel {
	private String productId;
	private String productName;
    private String productProcessor;
    private String productGPU;
    private String productBrand;
    private String productDisplay;
    private String productMemory;
    private String productStorage;
    private int productPrice;
    private String picture;
	public ProductModel(String productName, String productProcessor, String productGPU, String productBrand,
			String productDisplay, String productMemory, String productStorage, int productPrice, String picture) {
		super();
		this.productName = productName;
		this.productProcessor = productProcessor;
		this.productGPU = productGPU;
		this.productBrand = productBrand;
		this.productDisplay = productDisplay;
		this.productMemory = productMemory;
		this.productStorage = productStorage;
		this.productPrice = productPrice;
		this.picture = picture;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductProcessor() {
		return productProcessor;
	}
	public void setProductProcessor(String productProcessor) {
		this.productProcessor = productProcessor;
	}
	public String getProductGPU() {
		return productGPU;
	}
	public void setProductGPU(String productGPU) {
		this.productGPU = productGPU;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductDisplay() {
		return productDisplay;
	}
	public void setProductDisplay(String productDisplay) {
		this.productDisplay = productDisplay;
	}
	public String getProductMemory() {
		return productMemory;
	}
	public void setProductMemory(String productMemory) {
		this.productMemory = productMemory;
	}
	public String getProductStorage() {
		return productStorage;
	}
	public void setProductStorage(String productStorage) {
		this.productStorage = productStorage;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
    
    
}
