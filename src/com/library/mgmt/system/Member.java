package com.library.mgmt.system;

import java.time.LocalDate;
import java.util.Date;

public class Member extends Account {
	private Date startDateOfMembership;
	private Date endDateOfMembership;
	private int totalBooksCheckout;

	public int totalBooksCheckout() {
		return totalBooksCheckout;

	}

	@Override
	public boolean resetPassword() {
		return false;
	}

	public void reserveBookItem(BookItem bookItem) {

	}

	public void incrementTotalBooksCheckoutCount() {
		totalBooksCheckout++;
	}

	public boolean checkoutBookItem(BookItem bookItem) {
		if (this.totalBooksCheckout >= Constant.MAX_BOOKS_ISSUED_TO_A_USER) {
			ShowError("The user has already checked-out maximum number of books");
			return false;
		}
		BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarCode());
		if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
			// book item has a pending reservation from another user
			ShowError("This book is reserved by another member");
			return false;
		} else if (bookReservation != null) {
			// book item has a pending reservation from the give member, update it
			bookReservation.updateStatus(ReservationStatus.COMPLETED);
		}

		if (!bookItem.checkout(this.getId())) {
			return false;
		}

		this.incrementTotalBooksCheckoutCount();
		return true;
	}

	private void ShowError(String string) {
		// TODO Auto-generated method stub

	}

	private void checkForFine(String bookItemBarcode) {
		BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
		Date dueDate = bookLending.getDueDate();
		Date today = new Date();
		// check if the book has been returned within the due date
		if (today.compareTo(dueDate) > 0) {
			long diff = today.getTime() - dueDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			Fine.collectFine(this.getId(), diffDays);
		}
	}

	public void returnBookItem(BookItem bookItem) {
		this.checkForFine(bookItem.getBarCode());
		BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarCode());
		if (bookReservation != null) {
			// book item has a pending reservation
			bookItem.updateBookItemStatus(BookStatus.RESERVED);
			bookReservation.sendBookAvailableNotification();
		}
		bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
	}

	public boolean renewBookItem(BookItem bookItem) {
		this.checkForFine(bookItem.getBarCode());
		BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarCode());
		// check if this book item has a pending reservation from another member
		if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
			ShowError("This book is reserved by another member");
			this.decrementTotalBooksCheckedout();
			bookItem.updateBookItemStatus(BookStatus.RESERVED);
			bookReservation.sendBookAvailableNotification();
			return false;
		} else if (bookReservation != null) {
			// book item has a pending reservation from this member
			bookReservation.updateStatus(ReservationStatus.COMPLETED);
		}
		BookLending.lendBook(bookItem.getBarCode(), this.getId());
		bookItem.updateDueDate(LocalDate.now().plusDays(Constant.MAX_LENDING_DAYS));
		return true;
	}

	private void decrementTotalBooksCheckedout() {

	}

	public Date getStartDateOfMembership() {
		return startDateOfMembership;
	}

	public Date getEndDateOfMembership() {
		return endDateOfMembership;
	}

	public int getTotalBooksCheckout() {
		return totalBooksCheckout;
	}
	
	

}
