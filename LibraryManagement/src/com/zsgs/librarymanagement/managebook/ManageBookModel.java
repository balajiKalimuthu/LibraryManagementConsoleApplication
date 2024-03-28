package com.zsgs.librarymanagement.managebook;

import com.zsgs.librarymanagement.datastorage.LibraryDataBase;

public class ManageBookModel {
	private LibraryDataBase dataBase = LibraryDataBase.getInstance();
	private ManageBookView manageBookView;

	ManageBookModel(ManageBookView manageBookView) {
		this.manageBookView = manageBookView;
	}

	public void createBook(String name, String authorName, String publication, String edition, String journer,
			int volume, int available) {
		dataBase.createBook(name, authorName, publication, edition, journer, volume, available);
		manageBookView.showMessage("\nBook Details is added...");
	}

	public void isAvailableBookIdToUpdate(int id) {
		if (!dataBase.isEmptyBookList()) {
			if (dataBase.isAvailableBookId(id)) {
				manageBookView.update(id);
				manageBookView.showMessage("\nBook Details is updated...");
			} else {
				manageBookView.showMessage("\nBook ID is unavailable...");
			}
		} else {
			manageBookView.showMessage("\nBook List is empty...");
		}
	}

	public void updateBook(int id, String name, String authorName, String publication, String edition, String journer,
			int volume, int available) {
		dataBase.updateBook(id, name, authorName, publication, edition, journer, volume, available);
	}

	public void isAvailableBookIdToRemove(int id) {
		if (!dataBase.isEmptyBookList()) {
			if (dataBase.isAvailableBookId(id)) {
				dataBase.removeBook(id);
				manageBookView.showMessage("\nBook Details is removed...");
			} else {
				manageBookView.showMessage("\nBook ID is unavailable...");
			}
		} else {
			manageBookView.showMessage("\nBook List is empty...");
		}
	}

	public void printList() {
		if (!dataBase.isEmptyBookList()) {
			dataBase.printBookList();
		} else {
			manageBookView.showMessage("\nBook List is empty...");
		}
	}

	public void searchBook() {
		if (!dataBase.isEmptyBookList()) {
			manageBookView.searchBook();
		} else {
			manageBookView.showMessage("\nBook List is empty...");
		}
	}

	public void searchBookById(int id) {
		dataBase.searchBookById(id);
	}

	public void searchBookByName(String name) {
		dataBase.searchBookByName(name);
	}

	public void searchBookByAuthor(String authorName) {
		dataBase.searchBookByAuthorName(authorName);
	}

	public void toExportData() {
		dataBase.exportData();
	}
}