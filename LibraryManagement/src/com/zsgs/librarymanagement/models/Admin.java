package com.zsgs.librarymanagement.models;

public class Admin {
	private String adminName;
	private int adminId;
	private String adminPhoneNo;
	private String adminEmailId;
	private String adminAddress;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPhoneNo() {
		return adminPhoneNo;
	}

	public void setAdminPhoneNo(String adminPhoneNo) {
		this.adminPhoneNo = adminPhoneNo;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
}