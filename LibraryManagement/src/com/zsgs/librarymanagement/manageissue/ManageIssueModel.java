package com.zsgs.librarymanagement.manageissue;

import com.zsgs.librarymanagement.datastorage.LibraryDataBase;

public class ManageIssueModel {
	private LibraryDataBase dataBase = LibraryDataBase.getInstance();
	private ManageIssueView manageIssueView;

	public ManageIssueModel(ManageIssueView manageIssueView) {
		this.manageIssueView = manageIssueView;
	}

	public void isAvailableUserList() {
		if (!dataBase.isEmptyUserList()) {
			manageIssueView.availableUser();
		} else {
			manageIssueView.showMessage("\nUser List is empty...");
			manageIssueView.showMessage("\nPlease add User to proceed...");
		}
	}

	public void isAvailableUser(int id) {
		if (dataBase.isAvailableUserId(id)) {
			manageIssueView.bookDetail(id);
		} else {
			manageIssueView.showMessage("\nUser ID is unavailable...");
			manageIssueView.showMessage("\nPlease add User to proceed...");
		}
	}

	public void isAvailableBook(int userId, int bookId) {
		if (dataBase.isAvailableBookId(bookId)) {
			if (dataBase.isAvailableBookCount(bookId)) {
				dataBase.proceedIssuing(userId, bookId);
				manageIssueView.showMessage("\nBook is issued to User...");
			} else {
				manageIssueView.showMessage("\nBook is out of stock...");
				manageIssueView.showMessage("\nTry any other books...");
			}
		} else {
			manageIssueView.showMessage("\nBook ID is not found...");
			manageIssueView.showMessage("\nTry any other books...");
		}
	}

	public void printIssuedList() {
		if (!dataBase.isEmptyIssueList()) {
			dataBase.printIssueList();
		} else {
			manageIssueView.showMessage("\nBooks are not issued...");
		}
	}

	public void printUserIssuedList() {
		if (!dataBase.isEmptyIssueList()) {
			manageIssueView.userIssue();
		} else {
			manageIssueView.showMessage("\nBooks are not issued...");
		}
	}

	public void isAvailableUserIssue(int userId) {
		if (!dataBase.isAvailableUserIssueId(userId)) {
			manageIssueView.showMessage("\nUser Id unavailable...");
		}
	}

	public void printBookIssuedList() {
		if (!dataBase.isEmptyIssueList()) {
			manageIssueView.bookIssue();
		} else {
			manageIssueView.showMessage("\nBooks are not issued...");
		}
	}

	public void isAvailableBookIssue(int bookId) {
		if (!dataBase.isAvailableBookIssueId(bookId)) {
			manageIssueView.showMessage("\nUser Id unavailable...");
		}
	}

	public void returnIssueBook() {
		if (!dataBase.isEmptyIssueList()) {
			manageIssueView.returnIssue();
		} else {
			manageIssueView.showMessage("\nNo books to retuen...");
		}
	}

	public void isAvailableReturnIssue(int issueId) {
		if (!dataBase.isAvailableIssueId(issueId)) {
			manageIssueView.showMessage("\nIssue Id unavailable...");
		}
	}

	public void toExportData() {
		dataBase.exportData();
	}
}