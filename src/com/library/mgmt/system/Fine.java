package com.library.mgmt.system;

import java.util.Date;

public class Fine {
	private Date creationDate;
	private double bookItemBarcode;
	private int memberId;

	public static void collectFine(int id, long diffDays) {
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public double getBookItemBarcode() {
		return bookItemBarcode;
	}

	public int getMemberId() {
		return memberId;
	}

}
