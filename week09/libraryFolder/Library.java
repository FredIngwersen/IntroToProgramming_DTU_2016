package week09.libraryFolder;

public class Library {

	public static void main(String[] args) {
		Book javatextbook =  new Book("Builiding Java Programs", "Reges and Stepp", 12312312311L);
		Book harrypotter1 = new Book("Harry Potter 1", "J.K. Rowling", 123123141245L);
		Book harrypotter2 = new Book("Harry Potter 2", "J.K. Rowling", 123123141246L);
		
		User albert = new User("Albert",10);
		User benny = new User("Benny");
		User charlie = new User("Charlie");
		
		albert.borrowBook(javatextbook);
		albert.borrowBook(harrypotter1);
		albert.borrowBook(harrypotter2);
		benny.borrowBook(javatextbook);
		albert.returnBook(javatextbook);
		
		albert.printStatus();
		benny.printStatus();
	}
}
