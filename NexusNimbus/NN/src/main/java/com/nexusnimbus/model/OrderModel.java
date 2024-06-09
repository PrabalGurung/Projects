package com.nexusnimbus.model;

public class OrderModel {
	    public int id;
	    public int customerId;
	    private String date;
	    public int totalAmt;
	    public String Status;
	    private String userName;
	    
	    
		public OrderModel(int id, int customerId, String date, int totalAmt, String status) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.date = date;
			this.totalAmt = totalAmt;
			Status = status;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getTotalAmt() {
			return totalAmt;
		}
		public void setTotalAmt(int totalAmt) {
			this.totalAmt = totalAmt;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
	    
	    
}
