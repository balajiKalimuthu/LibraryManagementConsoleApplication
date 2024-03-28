package com.zsgs.librarymanagement.librarysetup;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.manageissue.ManageIssueView;
import com.zsgs.librarymanagement.manageuser.ManageUserView;
import com.zsgs.librarymanagement.models.Library;

public class LibrarySetupView {

	private boolean valid;
	private LibraryManagement2024 libraryManagement2024 = LibraryManagement2024.getInstance();
	private LibrarySetupModel librarySetupModel;
	private Scanner sc = new Scanner(System.in);

	public LibrarySetupView() {
		librarySetupModel = new LibrarySetupModel(this);
	}

	public void init() {
		librarySetupModel.startSetup();
	}

	public void initiateSetup() {
		String id, name, phoneNo, emailId, address;
		System.out.println("\nEnter library details:");
		do {
			System.out.print(" Id: ");
			id = sc.nextLine();
			valid = librarySetupModel.validId(id);
		} while (!valid);
		valid = false;
		do {
			System.out.print("\n Name: ");
			name = sc.nextLine();
			valid = librarySetupModel.validName(name);
		} while (!valid);
		valid = false;
		do {
			System.out.print(" Phone No: ");
			phoneNo = sc.nextLine();
			valid = librarySetupModel.validPhoneNo(phoneNo);
		} while (!valid);
		valid = false;
		do {
			System.out.print(" Email Id: ");
			emailId = sc.nextLine();
			valid = librarySetupModel.validEmailId(emailId);
		} while (!valid);
		do {
			System.out.print(" Location: ");
			address = sc.nextLine();
			valid = librarySetupModel.validLocation(address);
		} while (!valid);
		valid = false;
		librarySetupModel.createLibrary(id, name, phoneNo, emailId, address);
	}

	public void onSetupComplete(Library library) {
		while (true) {
			try {
				System.out.println("\nCurrent Library Name - " + library.getLibraryName());
				System.out.print("\n 1. Manage Book\n 2. Manage User\n 3. Manage Issuing Books"
						+ "\n 9. Logout \n 0. Exit \n\nYour Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					new ManageBookView().init();
					break;
				case 2:
					new ManageUserView().init();
					break;
				case 3:
					new ManageIssueView().init();
					break;
				case 9:
					showMessage("\n--- Logout successful ---");
					librarySetupModel.toExportData();
					new LoginView().proceedLogin();
					return;
				case 0:
					librarySetupModel.toExportData();
					exit();
					return;
				default:
					showMessage("\nPlease enter valid choice");
				}
			} catch (InputMismatchException e) {
				showMessage("\nPlease enter valid choice");
				sc.nextLine();
				onSetupComplete(library);
			}
		}
	}

	private void exit() {
		showMessage("\n--- Logged out successfully ---");
		System.out.print("\n--- Thanks for using " + libraryManagement2024.getAppName());
		System.out.println(" v" + libraryManagement2024.getAppVersion() + " ---");
	}

	public void showMessage(String showMessage) {
		System.out.println(showMessage);
	}
}