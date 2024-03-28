package com.zsgs.librarymanagement.login;

import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView {

	private LibraryManagement2024 libraryManagement2024 = LibraryManagement2024.getInstance();
	private LoginModel loginModel;
	private Scanner sc = new Scanner(System.in);

	public LoginView() {
		loginModel = new LoginModel(this);
	}

	public void init() {
		System.out.println("\n\n--- " + libraryManagement2024.getAppName() + " ---");
		System.out.println("--- version " + libraryManagement2024.getAppVersion() + " ---");
		System.out.println("\nPlease login to proceed...");
		proceedLogin();
	}

	private void checkForLogin() {
		System.out.println("\nDo you want to try again?");
		System.out.println("Type: Yes / No");
		System.out.print("\n Your Choice: ");
		String type = sc.nextLine();
		loginModel.isType(type);
	}

	public void onLoginSuccess() {
		System.out.println("\n--- Login successful ---\n");
		System.out.print("\nwelcome to " + libraryManagement2024.getAppName());
		System.out.println(" - v" + libraryManagement2024.getAppVersion());
		LibrarySetupView librarySetupView = new LibrarySetupView();
		librarySetupView.init();
	}

	public void proceedLogin() {
		System.out.println("\nLOGIN PAGE:");
		System.out.print("\n Enter Admin's Name: ");
		String userName = sc.nextLine();
		System.out.print(" Enter Admin's Password: ");
		String userPassword = sc.nextLine();
		loginModel.validateUser(userName, userPassword);
	}

	public void onLoginFailed(String alertMessage) {
		System.out.println(alertMessage);
		checkForLogin();
	}

	public void endMessage() {
		System.out.print("\n--- Thanks for using " + libraryManagement2024.getAppName());
		System.out.println(" v" + libraryManagement2024.getAppVersion() + " ---");
	}
}