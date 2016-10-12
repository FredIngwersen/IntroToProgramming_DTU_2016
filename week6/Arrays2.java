package week6;

public class Arrays2 {

	public static void main(String[] args) {

	}

	public static int countInRange(int [] a, int min, int max){
		
		int count = 0;
		
		for(int i = 1; i <= a.length; i++){
			if(a[i-1] >= min && a[i-1] <= max){
				count++;
			}
		}
		return count;
	}
}
