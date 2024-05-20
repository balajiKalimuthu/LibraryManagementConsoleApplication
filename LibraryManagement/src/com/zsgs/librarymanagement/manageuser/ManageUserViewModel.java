package com.zsgs.librarymanagement.manageuser;

import com.zsgs.librarymanagement.datastorage.LibraryDataBase;
import com.zsgs.librarymanagement.vadidator.ValueValidator;

public class ManageUserViewModel {
	private LibraryDataBase dataBase = LibraryDataBase.getInstance();
	private ManageUserView manageUserView;

	ManageUserViewModel(ManageUserView manageUserView) {
		this.manageUserView = manageUserView;
	}

	public void isAvailablePhoneNo(String phoneNo) {
		if (!dataBase.isEmptyUserList()) {
			if (!dataBase.isAvailableUserPhoneNo(phoneNo)) {
				manageUserView.create(phoneNo);
			} else {
				manageUserView.showMessage("\nUser is already availabe...");
			}
		} else {
			manageUserView.create(phoneNo);
		}
	}

	public void createUser(String name, String phoneNo, String emailId, String address) {
		dataBase.createUser(name, phoneNo, emailId, address);
		manageUserView.showMessage("\nUser is added...");
	}

	public void isAvailableUserIdToUpdate(int id) {
		if (!dataBase.isEmptyUserList()) {
			if (dataBase.isAvailableUserId(id)) {
				manageUserView.update(id);
				manageUserView.showMessage("\nUser Details is updated...");
			} else {
				manageUserView.showMessage("\nUser ID is unavailable...");
			}
		} else {
			manageUserView.showMessage("\nUser List is empty...");
		}
	}

	public void updateUser(int id, String name, String phoneNo, String emailId, String address) {
		dataBase.updateUserList(id, name, phoneNo, emailId, address);
	}

	public void isAvailableUserIdToRemove(int id) {
		if (!dataBase.isEmptyUserList()) {
			if (dataBase.isAvailableUserId(id)) {
				dataBase.removeUser(id);
				manageUserView.showMessage("\nUser Details is removed...");
			} else {
				manageUserView.showMessage("\nUser ID is unavailable...");
			}
		} else {
			manageUserView.showMessage("\nUser List is empty...");
		}
	}

	public void searchUser() {
		if (!dataBase.isEmptyUserList()) {
			manageUserView.search();
		} else {
			manageUserView.showMessage("\nUser List is empty...");
		}
	}

	public void isAvailableUserIdToSearch(int id) {
		if (dataBase.isAvailableUserId(id)) {
			dataBase.searchUserById(id);
		} else {
			manageUserView.showMessage("\nUser ID is unavailable...");
		}
	}

	public void printUserList() {
		if (!dataBase.isEmptyUserList()) {
			dataBase.printUserList();
		} else {
			manageUserView.showMessage("\nUser List is empty...");
		}
	}

	public boolean validName(String name) {
		if (!ValueValidator.validateName(name)) {
			manageUserView.showMessage("\n Name format must follows:");
			manageUserView.showMessage("  - contains only alphabets, dot, space.");
			manageUserView.showMessage("  - maximum length: 15 characters.");
		}
		return ValueValidator.validateName(name);
	}

	public boolean validPhoneNo(String phoneNo) {
		if (!ValueValidator.validatePhoneNo(phoneNo)) {
			manageUserView.showMessage("\n Phone No contains only 0-9 with length 10 digits.");
		}
		return ValueValidator.validatePhoneNo(phoneNo);
	}

	public boolean validEmailId(String emailId) {
		if (!ValueValidator.validateEmailId(emailId)) {
			manageUserView.showMessage("\n Email format must follows:");
			manageUserView.showMessage("  - contains only small alphabets, numbers, dot, hyphen.");
			manageUserView.showMessage("  - must ends with @gmail.com.");
			manageUserView.showMessage("  - maximum length: 20 characters.");
		}
		return ValueValidator.validateEmailId(emailId);
	}

	public boolean validLocation(String location) {
		if (!ValueValidator.validateLocation(location)) {
			manageUserView.showMessage("\n Location format must follows:");
			manageUserView.showMessage("  - contains only alphabets, space.");
			manageUserView.showMessage("  - maximum length: 15 characters.");
		}
		return ValueValidator.validateLocation(location);
	}

	public void toExportData() {
		dataBase.exportData();
	}
}