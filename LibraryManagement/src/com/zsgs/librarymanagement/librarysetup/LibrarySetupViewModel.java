package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.datastorage.LibraryDataBase;
import com.zsgs.librarymanagement.vadidator.ValueValidator;

public class LibrarySetupViewModel {

	private LibraryDataBase dataBase = LibraryDataBase.getInstance();
	private LibrarySetupView librarySetupView;

	LibrarySetupViewModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;
	}

	public void startSetup() {
		if (dataBase.getLibrary() == null || dataBase.getLibrary().getLibraryId().equals("0")) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete(dataBase.getLibrary());
		}
	}

	public void createLibrary(String id, String name, String phoneNo, String emailId, String address) {
		dataBase.insertLibrary(id, name, phoneNo, emailId, address);
		librarySetupView.onSetupComplete(dataBase.getLibrary());
	}

	public boolean validId(String id) {
		if (!ValueValidator.validateId(id)) {
			librarySetupView.showMessage("\n ID format must follows:");
			librarySetupView.showMessage(" - contains only whole numbers.");
			librarySetupView.showMessage(" - maximum length: 7 digits.");
		}
		return ValueValidator.validateId(id);
	}

	public boolean validName(String name) {
		if (!ValueValidator.validateName(name)) {
			librarySetupView.showMessage("\n Name format must follows:");
			librarySetupView.showMessage(" - contains only alphabets, dot, space.");
			librarySetupView.showMessage(" - maximum length: 15 characters.");
		}
		return ValueValidator.validateName(name);
	}

	public boolean validPhoneNo(String phoneNo) {
		if (!ValueValidator.validatePhoneNo(phoneNo)) {
			librarySetupView.showMessage("\n Phone No contains only 0-9 with length 10 digits.");
		}
		return ValueValidator.validatePhoneNo(phoneNo);
	}

	public boolean validEmailId(String emailId) {
		if (!ValueValidator.validateEmailId(emailId)) {
			librarySetupView.showMessage("\n Email format must follows:");
			librarySetupView.showMessage(" - contains only small alphabets, numbers, dot, hyphen.");
			librarySetupView.showMessage(" - must ends with @gmail.com.");
			librarySetupView.showMessage(" - maximum length: 20 characters.");
		}
		return ValueValidator.validateEmailId(emailId);
	}

	public boolean validLocation(String location) {
		if (!ValueValidator.validateLocation(location)) {
			librarySetupView.showMessage("\n Location format must follows:");
			librarySetupView.showMessage(" - contains only alphabets, space.");
			librarySetupView.showMessage(" - maximum length: 15 characters.");
		}
		return ValueValidator.validateLocation(location);
	}

	public void toExportData() {
		dataBase.exportData();
	}
}