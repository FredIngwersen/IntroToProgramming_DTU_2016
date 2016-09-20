package week4;

public class opgave4_3 {

	public static void main(String[] args) {
		
		yesOrNo("Hello java.");
		
		yesOrNo("Hello world.");
	}
	
	public static void yesOrNo(String s){
		if(s.contains("java") || s.contains("nova")){
			System.out.println("yes");
		} else{
			System.out.println("no");
		}
	}

}
