package com.zsgs.librarymanagement.models;

public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublication;
	private String bookEdition;
	private String bookJourner;
	private int bookVolume;
	private int bookAvailableCount;

	public void printBookList() {
		System.out.format("\n    | %-4s | %-25s | %-15s | %-15s | %-6s | %-15s | %-15s | %-5s |", bookId, bookName,
				bookAuthor, bookEdition, bookVolume, bookJourner, bookPublication, bookAvailableCount);
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublication() {
		return bookPublication;
	}

	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public String getBookJourner() {
		return bookJourner;
	}

	public void setBookJourner(String bookJourner) {
		this.bookJourner = bookJourner;
	}

	public int getBookVolume() {
		return bookVolume;
	}

	public void setBookVolume(int bookVolume) {
		this.bookVolume = bookVolume;
	}

	public int getBookAvailableCount() {
		return bookAvailableCount;
	}

	public void setBookAvailableCount(int bookAvailableCount) {
		this.bookAvailableCount = bookAvailableCount;
	}
}