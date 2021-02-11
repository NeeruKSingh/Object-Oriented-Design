package com.library.mgmt.system;

import java.time.LocalDate;
import java.util.Date;

public class BookItem extends Book {
	private String barcode;
	private boolean isReferenceOnly;
	private Date borrowed;
	private Date dueDate;
	private double price;
	private BookFormat format;
	private BookStatus status;
	private Date dateOfPurchase;
	private Date publicationDate;
	private Rack placedAt;

	public boolean checkout(String memberId) {
		if (this.getIsReferenceOnly()) {
			ShowError("This book is Reference only and can't be issued");
			return false;
		}
		if (!BookLending.lendBook(this.getBarCode(), memberId)) {
			return false;
		}
		this.updateBookItemStatus(BookStatus.LOANED);
		return true;
	}

	public String getBarCode() {
		return barcode;
	}

	private boolean getIsReferenceOnly() {
		return isReferenceOnly;
	}

	private void ShowError(String string) {

	}

	void updateBookItemStatus(BookStatus loaned) {

	}

	public boolean checkout(int id) {
		return false;
	}

	public void updateDueDate(LocalDate plusDays) {

	}

	public String getBarcode() {
		return barcode;
	}

	public Date getBorrowed() {
		return borrowed;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public double getPrice() {
		return price;
	}

	public BookFormat getFormat() {
		return format;
	}

	public BookStatus getStatus() {
		return status;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public Rack getPlacedAt() {
		return placedAt;
	}
	
	

}
