package com.zsgs.librarymanagement.datastorage;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.zsgs.librarymanagement.datalayer.DataLayer;
import com.zsgs.librarymanagement.models.Book;
import com.zsgs.librarymanagement.models.BookIssue;
import com.zsgs.librarymanagement.models.Library;
import com.zsgs.librarymanagement.models.User;

public class LibraryDataBase {
	private static LibraryDataBase dataBase;
	private static int issueId = 1;
	private static int userId = 101;
	private static int bookId = 1001;
	private static DataLayer dataLayer;
	private Library library;
	private Map<Integer, Library> libraryList = new HashMap<Integer, Library>();
	private Map<Integer, BookIssue> bookIssueList = new HashMap<Integer, BookIssue>();
	private Map<Integer, Book> bookList = new HashMap<Integer, Book>();
	private Map<Integer, User> userList = new HashMap<Integer, User>();
	
	private LibraryDataBase() {
	}

	public static LibraryDataBase getInstance() {
		if (dataBase == null) {
			dataBase = new LibraryDataBase();
			dataLayer = new DataLayer();
		}
		return dataBase;
	}

	public Library getLibrary() {
		for (Map.Entry<Integer, Library> map : libraryList.entrySet()) {
			library = map.getValue();
			break;
		}
		return library;
	}

	public void insertLibrary(String id, String name, String phoneNo, String emailId, String address) {
		library = new Library();
		library.setLibraryId(id);
		library.setLibraryName(name);
		library.setLibraryPhoneNo(phoneNo);
		library.setLibraryEmailId(emailId);
		library.setLibraryAddress(address);
		int num = Integer.parseInt(id);
		libraryList.put(num, library);
		exportData();
	}

	public void createBook(String name, String authorName, String publication, String edition, String journer,
			int volume, int available) {
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(name);
		book.setBookAuthor(authorName);
		book.setBookPublication(publication);
		book.setBookEdition(edition);
		book.setBookJourner(journer);
		book.setBookVolume(volume);
		book.setBookAvailableCount(available);
		bookList.put(bookId++, book);
		exportData();
	}

	public boolean isEmptyBookList() {
		return bookList.isEmpty();
	}

	public boolean isAvailableBookId(int id) {
		return bookList.containsKey(id);
	}

	public void updateBook(int id, String name, String authorName, String publication, String edition, String journer,
			int volume, int available) {
		bookList.get(id).setBookName(name);
		bookList.get(id).setBookAuthor(authorName);
		bookList.get(id).setBookPublication(publication);
		bookList.get(id).setBookEdition(edition);
		bookList.get(id).setBookJourner(journer);
		bookList.get(id).setBookVolume(volume);
		bookList.get(id).setBookAvailableCount(available);
		exportData();
	}

	public void removeBook(int id) {
		bookList.remove(id);
		exportData();
	}

	public void printBookList() {
		System.out.format("\n    | %-4s | %-25s | %-15s | %-15s | %-6s | %-15s | %-15s | %-5s |", "ID", "BOOK NAME",
				"AUTHOR NAME", "EDITION", "VOLUME", "JOURNER", "PUBLICATION", "COUNT");
		for (Map.Entry<Integer, Book> map : bookList.entrySet()) {
			bookList.get(map.getKey()).printBookList();
		}
	}

	public void searchBookById(int id) {
		System.out.format("\n    | %-4s | %-25s | %-15s | %-15s | %-6s | %-15s | %-15s | %-5s |", "ID", "BOOK NAME",
				"AUTHOR NAME", "EDITION", "VOLUME", "JOURNER", "PUBLICATION", "COUNT");
		for (Map.Entry<Integer, Book> map : bookList.entrySet()) {
			if (id == map.getKey()) {
				bookList.get(map.getKey()).printBookList();
				break;
			}
		}
	}

	public void searchBookByName(String name) {
		System.out.format("\n    | %-4s | %-25s | %-15s | %-15s | %-6s | %-15s | %-15s | %-5s |", "ID", "BOOK NAME",
				"AUTHOR NAME", "EDITION", "VOLUME", "JOURNER", "PUBLICATION", "COUNT");
		for (Map.Entry<Integer, Book> map : bookList.entrySet()) {
			String mapName = map.getValue().getBookName();
			name = name.toLowerCase();
			if (mapName.contains(name)) {
				map.getValue().printBookList();
			}
		}
	}

	public void searchBookByAuthorName(String authorName) {
		System.out.format("\n    | %-4s | %-25s | %-15s | %-15s | %-6s | %-15s | %-15s | %-5s |", "ID", "BOOK NAME",
				"AUTHOR NAME", "EDITION", "VOLUME", "JOURNER", "PUBLICATION", "COUNT");
		for (Map.Entry<Integer, Book> map : bookList.entrySet()) {
			String mapName = map.getValue().getBookAuthor();
			authorName = authorName.toLowerCase();
			if (mapName.contains(authorName)) {
				bookList.get(map.getKey()).printBookList();
			}
		}
	}

	public boolean isEmptyUserList() {
		return userList.isEmpty();
	}

	public boolean isAvailableUserPhoneNo(String phoneNo) {
		for (Map.Entry<Integer, User> map : userList.entrySet()) {
			if (phoneNo == map.getValue().getUserPhoneNo()) {
				return true;
			}
		}
		return false;
	}

	public void createUser(String name, String phoneNo, String emailId, String address) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(name);
		user.setUserPhoneNo(phoneNo);
		user.setEmailId(emailId);
		user.setUserAddress(address);
		userList.put(userId++, user);
		exportData();
	}

	public boolean isAvailableUserId(int id) {
		return userList.containsKey(id);
	}

	public void updateUserList(int id, String name, String phoneNo, String emailId, String address) {
		userList.get(id).setUserName(name);
		userList.get(id).setUserPhoneNo(phoneNo);
		userList.get(id).setEmailId(emailId);
		userList.get(id).setUserAddress(address);
		exportData();
	}

	public void removeUser(int id) {
		userList.remove(id);
		exportData();
	}

	public void searchUserById(int id) {
		System.out.format("\n    | %-5s | %-15s | %-10s | %-20s | %-15s |\n", "Id", "User Name", "Phone No", "Email Id",
				"Address");
		userList.get(id).printUserList();
	}

	public void printUserList() {
		System.out.format("\n    | %-5s | %-15s | %-10s | %-20s | %-15s |\n", "Id", "User Name", "Phone No", "Email Id",
				"Address");
		for (Map.Entry<Integer, User> map : userList.entrySet()) {
			map.getValue().printUserList();
		}
	}

	public boolean isAvailableBookCount(int bookId) {
		return bookList.get(bookId).getBookAvailableCount() > 0;
	}

	public void proceedIssuing(int userId, int bookId) {
		BookIssue details = new BookIssue();
		details.setIssueId(issueId);
		details.setBookId(bookId);
		details.setUserId(userId);
		bookList.get(bookId).setBookAvailableCount(bookList.get(bookId).getBookAvailableCount() - 1);
		bookIssueList.put(issueId++, details);
		exportData();
	}

	public boolean isEmptyIssueList() {
		return bookIssueList.isEmpty();
	}

	public void printIssueList() {
		System.out.format("\n    | %-8s | %-7s | %-7s |\n", "ISSUE ID", "USER ID", "BOOK ID");
		for (Map.Entry<Integer, BookIssue> map : bookIssueList.entrySet()) {
			map.getValue().printList();
		}
	}

	public boolean isAvailableUserIssueId(int userId) {
		boolean valid = false;
		System.out.format("\n    | %-7s | %-8s | %-7s |\n", "USER ID", "ISSUE ID", "BOOK ID");
		for (Map.Entry<Integer, BookIssue> map : bookIssueList.entrySet()) {
			if (userId == map.getValue().getUserId()) {
				map.getValue().printUserList();
				valid = true;
			}
		}
		return valid;
	}

	public boolean isAvailableBookIssueId(int bookId) {
		boolean valid = false;
		System.out.format("\n    | %-7s | %-8s | %-7s |\n", "BOOK ID", "ISSUE ID", "USER ID");
		for (Map.Entry<Integer, BookIssue> map : bookIssueList.entrySet()) {
			if (bookId == map.getValue().getBookId()) {
				map.getValue().printBookList();
				valid = true;
			}
		}
		return valid;
	}

	public boolean isAvailableIssueId(int issueId) {
		boolean valid = false;
		if (bookIssueList.containsKey(issueId)) {
			int key = bookIssueList.get(issueId).getBookId();
			bookList.get(key).setBookAvailableCount(bookList.get(key).getBookAvailableCount() + 1);
			bookIssueList.remove(issueId);
			dataBase.serializeBookIssueList();
			valid = true;
		}
		return valid;
	}
	
	public void serializeBookIssueList() {
        dataLayer.serializeData(bookIssueList, "BookIssueList.txt");
    }
	public void deserializeBookIssueList() {
		Type bookIssueListType = new TypeToken<HashMap<Integer, BookIssue>>(){
		}.getType();
		bookIssueList = dataLayer.deserializeData("BookIssueList.txt", bookIssueListType, HashMap.class);
	}
	public void serializeLibrary() {
		dataLayer.serializeData(libraryList, "LibraryList.txt");
	}
	public void deserializeLibrary() {
		Type libraryListType = new TypeToken<HashMap<Integer, Library>>(){
		}.getType();
		libraryList =  dataLayer.deserializeData("LibraryList.txt", libraryListType, HashMap.class);
	}
	public void serializeBookList() {
        dataLayer.serializeData(bookList, "BookList.txt");
    }
	public void deserializeBookList() {
		Type bookListType = new TypeToken<HashMap<Integer, BookIssue>>(){
		}.getType();
		bookList = dataLayer.deserializeData("BookList.txt", bookListType, HashMap.class);
	}
	public void serializeUserList() {
        dataLayer.serializeData(userList, "UserList.txt");
    }
	public void deserializeUserList() {
		Type userListType = new TypeToken<HashMap<Integer, BookIssue>>(){
		}.getType();
		userList = dataLayer.deserializeData("UserList.txt", userListType, HashMap.class);
	}
	public void exportData() {
		serializeBookIssueList();
		serializeBookList();
		serializeLibrary();
		serializeUserList();
	}
	public void importData() {
		deserializeBookIssueList();
		deserializeBookList();
		deserializeLibrary();
		deserializeUserList();
	}
}