package javaÊµÑé¶þ;

import java.io.Serializable;
import java.util.Date;
public class BOOK implements Serializable
{
private String isbn,title,author,publisher;
private float price;
private Date date;
public BOOK(String isbn, String title, String author, String publisher, float price, Date date) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.price = price;
	this.date = date;
}
public BOOK() {
	super();
	// TODO Auto-generated constructor stub
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public void prtBK()
{
	String fmt="%-20s%-15s%-20s%-15s%-4.2f\n";
	System.out.printf(fmt,this.isbn,this.title,
			this.author,this.publisher,this.price);
}
}

