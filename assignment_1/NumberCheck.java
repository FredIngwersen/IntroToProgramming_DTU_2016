package assignment_1;

public class NumberCheck {

	public static void main(String[] args) {
		
		System.out.println(check("83535"));
		
	}
	
	public static boolean check(String number){

		// Declaring three variables
		int doubleNumber = 0; int crossSum = 0; int Cnumber;		
		
		for(int i = 0; i < number.length(); i++){
			
			// Because I will be counting backwards, I will make the following variable
			int flipi = number.length() - i;
			
			// Parsing the string into an integer
			Cnumber = Integer.parseInt(number.substring((flipi - 1), flipi));
			
			// Checking if the index is even
			if(i % 2 != 0){
				
				// Checking if double the digit is < 10, 
				if(Cnumber * 2 < 10){
					doubleNumber = Cnumber * 2;
				} else doubleNumber = ((Cnumber * 2) % 10) + 1;
			} else doubleNumber = Cnumber;
			
			crossSum += doubleNumber;
		}
		if(crossSum % 10 == 0){
			return true;
		} else return false;		
	}
	
}