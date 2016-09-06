package week2;


/*Write a program that produces the following output. Use a class constant to make it
possible to change the number of stairs in the figure.
				    o  *******
				   /|\ *	   *
				   / \ *	   *
			    o  ******	   *
			   /|\ * 		   *
			   / \ * 		   *
		   o  ****** 		   *
		  /|\ * 			   *
		  / \ * 			   *
 	  o  ****** 			   *
 	 /|\ * 					   *
 	 / \ *					   *
  o ****** 					   *
 /|\ * 						   *
 / \ *						   *
********************************
*/
public class opgave2_6 {
	private final static int stairs = 5;
	public static String floor = "******";
	public static String space = "-";
	
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= stairs; i++){
			
			for(int x = 1; x <= (stairs+(i*(-5))); x++){
				printSpace();
			}
			
		}
		printFloor();
		
	}
	public static void printHead(){
		System.out.println("  o  *******");
	}
	
	public static void printBody(){
		System.out.println(" /|\\ *	   ");
	}
	
	public static void printFeet(){
		System.out.println(" / \\ *	   ");
	}

	public static void printFloor(){
		for(int i = 1; i <= stairs; i++){
			System.out.print(floor);
		}
	}
	
	public static void printSpace(){
		for(int i = 1; i <= stairs; i++){
			System.out.print(space);
		}
	}

}
