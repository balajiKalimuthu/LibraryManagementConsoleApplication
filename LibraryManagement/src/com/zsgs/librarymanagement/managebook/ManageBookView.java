package com.zsgs.librarymanagement.managebook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageBookView {
	private ManageBookModel manageBookModel;
	private Scanner sc = new Scanner(System.in);

	public ManageBookView() {
		manageBookModel = new ManageBookModel(this);
	}

	public void init() {
		while (true) {
			try {
				System.out.println("\nManaging Books: ");
				System.out.print("\n 1. List the Book Details\n 2. Add Book Details\n 3. Update Book Details"
						+ "\n 4. Remove Book Details\n 5. Search Book Details\n 0. Back to Menu\n\nYour Choice: ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 0:
					manageBookModel.toExportData();
					return;
				case 1:
					manageBookModel.printList();
					break;
				case 2:
					createBook();
					break;
				case 3:
					updateBook();
					break;
				case 4:
					removeBook();
					break;
				case 5:
					manageBookModel.searchBook();
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

	private void createBook() {
		System.out.print("\nBook Name: ");
		String name = sc.nextLine();
		System.out.print("Author Name: ");
		String authorName = sc.nextLine();
		System.out.print("Publication: ");
		String publication = sc.nextLine();
		System.out.print("Book Edition: ");
		String edition = sc.nextLine();
		System.out.print("Book Journer: ");
		String journer = sc.nextLine();
		System.out.print("Book Volume: ");
		int volume = sc.nextInt();
		System.out.print("Available: ");
		int available = sc.nextInt();
		manageBookModel.createBook(name, authorName, publication, edition, journer, volume, available);
	}

	private void updateBook() {
		try {
			System.out.print("\nEnter Book ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			manageBookModel.isAvailableBookIdToUpdate(id);
			return;
		} catch (InputMismatchException e) {
			showMessage("\nPlease, Enter valid Book ID");
			sc.nextLine();
			updateBook();
		}
	}

	public void update(int id) {
		System.out.print("\nBook Name: ");
		String name = sc.nextLine();
		System.out.print("Author Name: ");
		String authorName = sc.nextLine();
		System.out.print("Publication: ");
		String publication = sc.nextLine();
		System.out.print("Book Edition: ");
		String edition = sc.nextLine();
		System.out.print("Book Journer: ");
		String journer = sc.nextLine();
		System.out.print("Book Volume: ");
		int volume = sc.nextInt();
		sc.nextLine();
		System.out.print("Available: ");
		int available = sc.nextInt();
		sc.nextLine();
		manageBookModel.updateBook(id, name, authorName, publication, edition, journer, volume, available);
	}

	private void removeBook() {
		try {
			System.out.print("\nEnter Book ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			manageBookModel.isAvailableBookIdToRemove(id);
		} catch (InputMismatchException e) {
			showMessage("\nPlease, Enter valid Book ID");
			sc.nextLine();
			removeBook();
		}
	}

	public void searchBook() {
		try {
			System.out.println("\n 1. Search by Book Id\n 2. Search by Book Name\n 3. Search by Author Name\n 0. Exit");
			System.out.print("\nYour Choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				try {
					System.out.print("\n Book Id: ");
					int id = sc.nextInt();
					sc.nextLine();
					manageBookModel.searchBookById(id);
				} catch (InputMismatchException e) {
					System.out.println("\nPlease enter valid input");
				}
				break;
			case 2:
				System.out.print("\n Book Name: ");
				String name = sc.nextLine();
				manageBookModel.searchBookByName(name);
				break;
			case 3:
				System.out.print("\n Author Name: ");
				String authorName = sc.nextLine();
				manageBookModel.searchBookByAuthor(authorName);
				break;
			case 0:
			default:
				return;
			}
		} catch (InputMismatchException e) {
			System.out.println("\nPlease enter valid input");
			return;
		}
	}

	public void showMessage(String showMessage) {
		System.out.println(showMessage);
	}
}