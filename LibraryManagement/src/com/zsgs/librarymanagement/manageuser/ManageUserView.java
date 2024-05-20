package com.zsgs.librarymanagement.manageuser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageUserView {
	private boolean valid;
	private ManageUserViewModel manageUserViewModel;
	private Scanner sc = new Scanner(System.in);

	public ManageUserView() {
		manageUserViewModel = new ManageUserViewModel(this);
	}

	public void init() {
		while (true) {
			try {
				System.out.println("\nManaging Users: ");
				System.out.print("\n 1. List the User Details\n 2. Add User Details\n 3. Update User Details"
						+ "\n 4. Remove User Details\n 5. Search User Details\n 0. Back to Menu\n\nYour Choice: ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 0:
					manageUserViewModel.toExportData();
					return;
				case 1:
					manageUserViewModel.printUserList();
					break;
				case 2:
					phoneNo();
					break;
				case 3:
					updateUser();
					break;
				case 4:
					removeUser();
					break;
				case 5:
					manageUserViewModel.searchUser();
					break;
				default:
					System.out.println("\nPlease, Enter valid choice");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nPlease, Enter valid choice");
				sc.nextLine();
				init();
			}
		}
	}

	private void phoneNo() {
		String phoneNo;
		do {
			System.out.print("\n Phone No: ");
			phoneNo = sc.nextLine();
			valid = manageUserViewModel.validPhoneNo(phoneNo);
		} while (!valid);
		valid = false;
		manageUserViewModel.isAvailablePhoneNo(phoneNo);
	}

	private void removeUser() {
		try {
			System.out.print("\nEnter User ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			manageUserViewModel.isAvailableUserIdToRemove(id);
		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
			sc.nextLine();
			removeUser();
		}
	}

	public void create(String phoneNo) {
		String name, emailId, address;
		do {
			System.out.print("\n User's Name: ");
			name = sc.nextLine();
			valid = manageUserViewModel.validName(name);
		} while (!valid);
		do {
			System.out.print(" User's Email Id: ");
			emailId = sc.nextLine();
			valid = manageUserViewModel.validEmailId(emailId);
		} while (!valid);
		do {
			System.out.print(" User's Location: ");
			address = sc.nextLine();
			valid = manageUserViewModel.validLocation(address);
		} while (!valid);
		valid = false;
		manageUserViewModel.createUser(name, phoneNo, emailId, address);
	}

	private void updateUser() {
		try {
			System.out.print("\nEnter User ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			manageUserViewModel.isAvailableUserIdToUpdate(id);
			return;
		} catch (InputMismatchException e) {
			showMessage("\nPlease, Enter valid Book ID");
			sc.nextLine();
			updateUser();
		}
	}

	public void showMessage(String showMessage) {
		System.out.println(showMessage);
	}

	public void update(int id) {
		String name, phoneNo, emailId, address;
		do {
			System.out.print("\n User's Name: ");
			name = sc.nextLine();
			valid = manageUserViewModel.validName(name);
		} while (!valid);
		do {
			System.out.print(" User's Phone No: ");
			phoneNo = sc.nextLine();
			valid = manageUserViewModel.validPhoneNo(phoneNo);
		} while (!valid);
		do {
			System.out.print(" User's Email Id: ");
			emailId = sc.nextLine();
			valid = manageUserViewModel.validEmailId(emailId);
		} while (!valid);
		do {
			System.out.print(" User's Location: ");
			address = sc.nextLine();
			valid = manageUserViewModel.validLocation(address);
		} while (!valid);
		valid = false;
		manageUserViewModel.updateUser(id, name, phoneNo, emailId, address);
	}

	public void search() {
		try {
			System.out.print("\nEnter User ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			manageUserViewModel.isAvailableUserIdToSearch(id);
			return;
		} catch (InputMismatchException e) {
			showMessage("\nPlease, Enter valid Book ID");
			sc.nextLine();
			search();
		}
	}
}