package com.System;

import javax.xml.crypto.Data;

public class Book {
	private String bookId;
	private String bookName;
	private String author;
	private String bookPress;
	private int price;
	private String date = "Î´½è³ö";
	private int shu;
	private int lendshu;
	private String date1="Î´½è³ö";

	public Book() {

	}

	public Book(String bookId, String bookName, String author, String bookPress, int price, String date, int shu,
			String date1, int lendshu) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.bookPress = bookPress;
		this.price = price;
		this.date = date;
		this.date1 = date1;
		this.lendshu = lendshu;
	}

	public int getLendshu() {
		return lendshu;
	}

	public void setLendshu(int lendshu) {
		this.lendshu = lendshu;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public int getShu() {
		return shu;
	}

	public void setShu(int shu) {
		this.shu = shu;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookPress() {
		return bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
