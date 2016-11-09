package week02;

public class opgave2_5 {
	
	
	public static void main(String[] args){
		
		printDesign();

		}
	
	public static void printDesign(){
		int c = 0;
		for(int i = 1; i <= 9; i += 2){
			for(int k = 0; k < (5-c); k++){
				System.out.print("-");
			}
			for(int j = 1; j <= i; j++){
				System.out.print(i);
			}
			for(int k = 1; k <= (5-c); k++){
				System.out.print("-");
			}
			
			System.out.println();
			c++;

		}
	}
}
