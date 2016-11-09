package week09.libraryFolder;

public class Book {
	private String title, author;
	private long isbn13;
	private long datePublished;
	private boolean isAvailable;
	
	public Book(String title, String author, long isbn13) {
		this.title = title;
		this.author = author;
		this.isbn13 = isbn13;
		this.isAvailable = true;
	}
	
	public String toString() {
		return this.title+" by "+this.author;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}
}
