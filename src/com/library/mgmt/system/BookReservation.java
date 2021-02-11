package com.library.mgmt.system;

import java.util.Date;

public class BookReservation {
	private Date creationDate;
	private ReservationStatus status;
	private String bookItemBarcode;
	private int memberId;

	public static BookReservation fetchReservationDetails(String barcode) {
		return null;

	}

	public Date getCreationDate() {
		return creationDate;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public String getBookItemBarcode() {
		return bookItemBarcode;
	}

	public int getMemberId() {
		return memberId;
	}

	public void updateStatus(ReservationStatus completed) {
		// TODO Auto-generated method stub

	}

	public void sendBookAvailableNotification() {
		// TODO Auto-generated method stub

	}

}
