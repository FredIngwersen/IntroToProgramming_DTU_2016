package week04;

public class CaesarCipher {

	public static void main(String[] args) {
		
		System.out.println(encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 17));

		
		System.out.println(decode(encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 17), 17));
		
	}
	
	public static String encode(String text, int shift){
		
		String encodedString = "";
		int encoded = 0;
		int ascii;
		char letter;
		
		for(int i = 0; i < text.length(); i++){
			letter = text.charAt(i);
			if(letter < 65 || letter > 90 || shift > 25){
				return "**ERROR**";
			}
			ascii = (int) letter;
			if(ascii + shift > 90){
				encoded = (ascii + shift) - 90 + 64;
			} else {
				encoded = ascii + shift;
			}
			
			encodedString = encodedString + Character.toString((char) encoded);;
		}
		return encodedString;
	}
	
	public static String decode(String text, int shift){
		
		String encodedString = "";
		int encoded = 0;
		int ascii;
		char letter;
		
		for(int i = 0; i < text.length(); i++){
			letter = text.charAt(i);
			if(letter < 65 || letter > 90 || shift > 25){
				return "**ERROR**";
			}
			ascii = (int) letter;
			if(ascii - shift < 65){
				encoded = (ascii - shift) + 90 - 64;
			} else {
				encoded = ascii - shift;
			}
			
			encodedString = encodedString + Character.toString((char) encoded);;
		}
		return encodedString;
	}

}
