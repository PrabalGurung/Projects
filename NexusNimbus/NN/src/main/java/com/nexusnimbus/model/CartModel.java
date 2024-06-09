package com.nexusnimbus.model;

public class CartModel {
	    private int customerId;
	    private int prodId;
	    private int quantity;
	    private double amount;

	    public CartModel(int customerId, int prodId, int quantity, double amount) {
	        this.customerId = customerId;
	        this.prodId = prodId;
	        this.quantity = quantity;
	        this.amount = amount;
	    }

	    public int getCustomerId() {
	        return customerId;
	    }

	    public int getProdId() {
	        return prodId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public void setProdId(int prodId) {
	        this.prodId = prodId;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }
}
