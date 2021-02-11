package com.vending.machine;

public class NotFullPaidException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1135824451206020481L;
	private String message;
	private long remaining;

	public NotFullPaidException(String message, long remaining) {
		this.message = message;
		this.remaining = remaining;
	}

	public long getRemaining() {
		return remaining;
	}

	@Override
	public String getMessage() {
		return message + remaining;
	}
}
