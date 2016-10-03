package assignment_1;

public class NumberCheck {

	public static void main(String[] args) {
		
		System.out.println(check("0"));
		
	}
	
	public static boolean check(String number){
		
		// Checking for a "0" at the start of the string, 
		// if a "0" is found; it will be removed.
		// Unless this is the only digit.
		if(number.length() > 1){
			while(Integer.parseInt(number.substring(0, 1)) == 0){
				number = number.substring(1);
			}
		}
		int doubleNumber = 0; int crossSum = 0; int Cnumber;		
		
		for(int i = 0; i < number.length(); i++){
			
			// Parsing the string into an integer
			Cnumber = Integer.parseInt(number.substring(i, i + 1));
			
			// Checking if the index is even
			if(i % 2 == 0){
				
				// Checking if double the digit is < 10
				if(Cnumber * 2 < 10){
					
					doubleNumber = Cnumber * 2;
				} else {
					doubleNumber = ((Cnumber * 2) % 10) + 1;
				}
			} else {
				doubleNumber = Cnumber;
			}
			
			crossSum = crossSum + doubleNumber;
		}
		if(crossSum % 10 == 0){
			return true;
		} else {
			return false;
		}
		
	}
	
}