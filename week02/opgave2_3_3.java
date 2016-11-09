package week02;


/* Print the following output:
999999999888888887777777666666555554444333221
999999999888888887777777666666555554444333221
999999999888888887777777666666555554444333221
999999999888888887777777666666555554444333221
*/

public class opgave2_3_3 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 4; i++){
			for(int k = 9; k !=-1; k--){
				for(int j = 1; j<=k; j++)
				System.out.print(k);
				
			}
			System.out.println();
		}
	}

}
