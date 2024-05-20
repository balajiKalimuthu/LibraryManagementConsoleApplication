package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.datastorage.LibraryDataBase;

public class LoginViewModel {

	private LibraryDataBase dataBase = LibraryDataBase.getInstance();
	private LoginView loginView;

	LoginViewModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void isType(String type) {
		if (type.equalsIgnoreCase("yes")) {
			loginView.proceedLogin();
		} else if (type.equalsIgnoreCase("no")) {
			dataBase.exportData();
			loginView.endMessage();
		} else {
			loginView.onLoginFailed("\nPlease enter valid choice...");
		}
	}

	public void validateUser(String userName, String userPassword) {
		if (isValidUserName(userName)) {
			if (isValidUserPassword(userName, userPassword)) {
				loginView.onLoginSuccess();
			} else {
				loginView.onLoginFailed("\nInvalid User Password");
			}
		} else {
			loginView.onLoginFailed("\nInvalid User Name");
		}
	}

	private boolean isValidUserName(String userName) {
		return userName.equals("zsgs") || userName.equals("zsgsadmin");
	}

	private boolean isValidUserPassword(String userName, String userPassword) {
		return (userName.equals("zsgs") && userPassword.equals("admin"))
				|| (userName.equals("zsgsadmin") && userPassword.equals("admin123"));
	}
}