package week6;

import java.util.Arrays;

public class Arrays3 {

	public static void main(String[] args) {
		
		int array[] = {1,2,3,4,5,2,2,1,2,3,4,6,8,9,23,12,12,11,22};
		
		System.out.println(mode(array));
		
		
	}

	public static int mode(int[] a){
		
		int[] count = new int[101];
		
		for(int i = 0; i < a.length; i++){
			count[a[i]]++;
		}
		
		int maxCount = 0;
		int modeValue = 0;
		
		for(int i = 0; i < count.length; i++){
			if(count[i] > maxCount){
				maxCount = count[i];
				modeValue = i;
			}
		}
		return modeValue;
	}
	
	public static int modeX(int[] a){
		
		int[] count = [];
		
		for(int i = 0; i < a.length; i++){
			count[a[i]]++;
		}
		
		int maxCount = 0;
		int modeValue = 0;
		
		for(int i = 0; i < count.length; i++){
			if(count[i] > maxCount){
				maxCount = count[i];
				modeValue = i;
			}
		}
		return modeValue;
	}
}
