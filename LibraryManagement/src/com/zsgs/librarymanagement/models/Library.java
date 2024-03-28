package com.zsgs.librarymanagement.models;

public class Library {
	private String libraryName;
	private String libraryId;
	private String libraryPhoneNo;
	private String libraryEmailId;
	private String libraryAddress;

	public Library() {
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryPhoneNo() {
		return libraryPhoneNo;
	}

	public void setLibraryPhoneNo(String libraryPhoneNo) {
		this.libraryPhoneNo = libraryPhoneNo;
	}

	public String getLibraryEmailId() {
		return libraryEmailId;
	}

	public void setLibraryEmailId(String libraryEmailId) {
		this.libraryEmailId = libraryEmailId;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}
}