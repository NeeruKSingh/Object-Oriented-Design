package com.library.mgmt.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Catalog implements Search {
	private HashMap<String, List<Book>> bookTitles;
	private HashMap<String, List<Book>> bookAuthors;
	private HashMap<String, List<Book>> bookSubjects;
	private HashMap<String, List<Book>> bookPublicationDates;

	@Override
	public List<Book> searchByTitle(String title) {
		return null;
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		return null;
	}

	@Override
	public List<Book> searchBySubject(String subject) {
		return null;
	}

	@Override
	public List<Book> searchByPubDate(Date publishDate) {
		return null;
	}

	public HashMap<String, List<Book>> getBookTitles() {
		return bookTitles;
	}

	public HashMap<String, List<Book>> getBookAuthors() {
		return bookAuthors;
	}

	public HashMap<String, List<Book>> getBookSubjects() {
		return bookSubjects;
	}

	public HashMap<String, List<Book>> getBookPublicationDates() {
		return bookPublicationDates;
	}

}
