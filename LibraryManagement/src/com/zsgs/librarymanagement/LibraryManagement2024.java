package com.zsgs.librarymanagement;

import com.zsgs.librarymanagement.datastorage.LibraryDataBase;
import com.zsgs.librarymanagement.login.LoginView;

public class LibraryManagement2024 {

	private static LibraryManagement2024 libraryManagement2024;
	private LibraryDataBase dataBase = LibraryDataBase.getInstance();
	private String appName = "Library Management System";
	private String appVersion = "0.0.1";

	private LibraryManagement2024() {
	}

	public static void main(String[] args) {
		LibraryManagement2024.getInstance().create();
	}

	private void create() {
		dataBase.importData();
		LoginView loginView = new LoginView();
		loginView.init();
	}

	public static LibraryManagement2024 getInstance() {
		if (libraryManagement2024 == null) {
			libraryManagement2024 = new LibraryManagement2024();
		}
		return libraryManagement2024;
	}

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}
}