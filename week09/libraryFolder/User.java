package week09.libraryFolder;

import java.util.Arrays;

public class User {
	private String name;
	private Book[] myBooks;
	private int numberOfBooks;

	// Defines a user, with a name, and an underlying value.
	public User(String name) {
		this(name,10);
	}
	// Here the underlying value/s can be seen
	public User(String name, int maxNumberOfBooks) {
		this.name = name;
		this.myBooks = new Book[maxNumberOfBooks];
		this.numberOfBooks = 0;
	}
	// Method for the user to borrow a book
	public void borrowBook(Book book) {
		if (!book.isAvailable()) {
			System.out.println("Book is not available.");
		} else if (numberOfBooks >= myBooks.length) {
			System.out.println("User has exceeded his quota.");
		} else {
			this.myBooks[numberOfBooks] = book;
			numberOfBooks++;
			book.setAvailable(false);
		}
	}
	// Method for the user to return a book.
	public void returnBook(Book book){
		for(int i = 0; i <= numberOfBooks; i++){
			if(book == myBooks[i]){
				this.myBooks[i] = null;
				numberOfBooks--;
				book.setAvailable(true);
				sortBooks(book);
			} else {
				System.out.println("You had not borrowed this books");
			}
		}

	}

	public String toString() {
		return this.name;
	}
	// Prints the current status of the selected user.
	public void printStatus() {
		String s = "Status for user: "+this.name+"\n";
		s += "has the books: "+Arrays.toString(this.myBooks);
		System.out.println(s);
	}
	// Sorts the books, so the list is not filled with "nulls" in between borrowed books.
	public void sortBooks(Book myBooks){
		for(int i = 0; i <= numberOfBooks; i++){
			if(!(this.myBooks[i+1] == null)){
				this.myBooks[i] = this.myBooks[i + 1];
				this.myBooks[i + 1] = null;
			}
		}
	}

}
