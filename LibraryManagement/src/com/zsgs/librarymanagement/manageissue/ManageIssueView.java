package com.zsgs.librarymanagement.manageissue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageIssueView {
	private ManageIssueModel manageIssueModel;
	private Scanner sc = new Scanner(System.in);

	public ManageIssueView() {
		manageIssueModel = new ManageIssueModel(this);
	}

	public void init() {
		while (true) {
			try {
				System.out.println("\nManage Issue Details: ");
				System.out.print("\n 1. Issue Book to User\n 2. List the Issued Details\n 3. User's Issued Book Details"
						+ "\n 4. Issued Book Details\n 5. Return Issued Book\n 0. Back to Menu\n\nYour Choice: ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 0:
					manageIssueModel.toExportData();
					return;
				case 1:
					manageIssueModel.isAvailableUserList();
					break;
				case 2:
					manageIssueModel.printIssuedList();
					break;
				case 3:
					manageIssueModel.printUserIssuedList();
					break;
				case 4:
					manageIssueModel.printBookIssuedList();
					break;
				case 5:
					manageIssueModel.returnIssueBook();
					break;
				default:
					showMessage("\nPlease enter valid choice...");
				}
			} catch (InputMismatchException e) {
				showMessage("\nPlease enter valid choice...");
				sc.nextLine();
				init();
			}
		}
	}

	public void showMessage(String showMessage) {
		System.out.println(showMessage);
	}

	public void availableUser() {
		try {
			System.out.print("\n User ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			manageIssueModel.isAvailableUser(id);

		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
		}
	}

	public void bookDetail(int userId) {
		try {
			System.out.print("\n Book ID: ");
			int bookId = sc.nextInt();
			sc.nextLine();
			manageIssueModel.isAvailableBook(userId, bookId);

		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
		}
	}

	public void userIssue() {
		try {
			System.out.print("\n User ID: ");
			int userId = sc.nextInt();
			sc.nextLine();
			manageIssueModel.isAvailableUserIssue(userId);

		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
		}
	}

	public void bookIssue() {
		try {
			System.out.print("\n Book ID: ");
			int bookId = sc.nextInt();
			sc.nextLine();
			manageIssueModel.isAvailableBookIssue(bookId);
		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid Book ID...");
		}
	}

	public void returnIssue() {
		try {
			System.out.print("\n Issue ID: ");
			int issueId = sc.nextInt();
			sc.nextLine();
			manageIssueModel.isAvailableReturnIssue(issueId);
		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid Book ID...");
		}
	}
}