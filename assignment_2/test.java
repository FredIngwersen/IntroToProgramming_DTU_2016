package assignment_2;

public class test {

	public static void main(String[] args) {
		
		TextAnalysis16 ta16 = new TextAnalysis16("TimeMachine.txt", 35000);
        int n = ta16.wordCount();
        System.out.println(n);

	}

}
