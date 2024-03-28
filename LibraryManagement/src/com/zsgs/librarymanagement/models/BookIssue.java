package com.zsgs.librarymanagement.models;

public class BookIssue {
	private int issueId;
	private int bookId;
	private int userId;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void printList() {
		System.out.format("\n    | %-8s | %-7s | %-7s |", issueId, userId, bookId);
	}

	public void printUserList() {
		System.out.format("\n    | %-7s | %-8s | %-7s |", userId, issueId, bookId);
	}

	public void printBookList() {
		System.out.format("\n    | %-7s | %-8s | %-7s |", bookId, issueId, userId);
	}
}