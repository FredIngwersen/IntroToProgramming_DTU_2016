package week02;

/* Print the follow output:
 * 1
 * 4
 * 9
 * 16
 * 25
 * 36
 * 49
 * 64
 * 81
 * 100*/

public class opgave2_2 {
	
	public static int j;
	
	public static void main(String[] args) {

		/*for(int i = 1; i <= 6; i++){
			j = i * i;
			System.out.println(j);

		}*/
		
		int t = 0;
		for(int i = 0; i <= 9; i++){
			t += ((i*2)+1);
			System.out.println(t);
		}
	}
}

