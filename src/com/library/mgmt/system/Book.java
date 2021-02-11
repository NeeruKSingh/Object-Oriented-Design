package com.library.mgmt.system;

import java.util.List;

public abstract class Book {
	private String ISBN;
	private String title;
	private String subject;
	private String publisher;
	private String language;
	private int numberOfPages;
	private List<Author> authors;

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getSubject() {
		return subject;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getLanguage() {
		return language;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

}
