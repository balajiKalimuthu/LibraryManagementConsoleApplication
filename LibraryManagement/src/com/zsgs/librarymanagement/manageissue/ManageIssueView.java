package com.zsgs.librarymanagement.manageissue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageIssueView {
	private ManageIssueViewModel manageIssueViewModel;
	private Scanner sc = new Scanner(System.in);

	public ManageIssueView() {
		manageIssueViewModel = new ManageIssueViewModel(this);
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
					manageIssueViewModel.toExportData();
					return;
				case 1:
					manageIssueViewModel.isAvailableUserList();
					break;
				case 2:
					manageIssueViewModel.printIssuedList();
					break;
				case 3:
					manageIssueViewModel.printUserIssuedList();
					break;
				case 4:
					manageIssueViewModel.printBookIssuedList();
					break;
				case 5:
					manageIssueViewModel.returnIssueBook();
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
			manageIssueViewModel.isAvailableUser(id);

		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
		}
	}

	public void bookDetail(int userId) {
		try {
			System.out.print("\n Book ID: ");
			int bookId = sc.nextInt();
			sc.nextLine();
			manageIssueViewModel.isAvailableBook(userId, bookId);

		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
		}
	}

	public void userIssue() {
		try {
			System.out.print("\n User ID: ");
			int userId = sc.nextInt();
			sc.nextLine();
			manageIssueViewModel.isAvailableUserIssue(userId);

		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid User ID...");
		}
	}

	public void bookIssue() {
		try {
			System.out.print("\n Book ID: ");
			int bookId = sc.nextInt();
			sc.nextLine();
			manageIssueViewModel.isAvailableBookIssue(bookId);
		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid Book ID...");
		}
	}

	public void returnIssue() {
		try {
			System.out.print("\n Issue ID: ");
			int issueId = sc.nextInt();
			sc.nextLine();
			manageIssueViewModel.isAvailableReturnIssue(issueId);
		} catch (InputMismatchException e) {
			showMessage("\nPlease enter valid Book ID...");
		}
	}
}