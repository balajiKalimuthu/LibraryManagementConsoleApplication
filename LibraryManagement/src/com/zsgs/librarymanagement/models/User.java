package com.zsgs.librarymanagement.models;

public class User {
	private String userName;
	private int userId;
	private String userPhoneNo;
	private String userEmailId;
	private String userAddress;

	public void printUserList() {
		System.out.format("\n    | %-5s | %-15s | %-10s | %-20s | %-15s |", userId, userName, userPhoneNo, userEmailId,
				userAddress);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
}