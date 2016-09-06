package week2;

/*Print the following output:
000111222333444555666777888999
000111222333444555666777888999
000111222333444555666777888999
*/

public class opgave2_3 {
	
	public static void main(String[] args) {
		
		
		
		for(int i = 1; i <= 3; i++){
			for(int j = 0; j <=9; j++){
				for(int m = 1; m <= 3; m++)
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
