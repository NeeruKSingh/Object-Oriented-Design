package com.callcenter;

public class RankNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public RankNotFoundException(String msg) {
		super(msg);
	}

	public String getMessage() {
		return message;
	}

}
