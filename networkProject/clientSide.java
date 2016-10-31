package networkProject;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.io.*;
import java.net.ServerSocket;

public class clientSide {


	public static void main(String[] args) throws UnknownHostException, IOException{

		// Declaring values
		String hostName = "itkomsrv.fotonik.dtu.dk"; int portNumber = 1102;
		String bs =null;String winner = "";
		Socket MySocket = null;	MySocket = new Socket(hostName, portNumber);

		// Tries to get information from the specified server with the connection from "MySocket"
		try {
			BufferedReader bir = new BufferedReader(new InputStreamReader(MySocket.getInputStream()));
			PrintWriter pw = new PrintWriter(MySocket.getOutputStream());
			Scanner input = new Scanner(System.in);

			// Writes information to our console
			while(true){

				// We include this since we do not want the board state from the server, since we print the board
				String textline= bir.readLine();
				if(!textline.contains("BOARD IS")){
					System.out.print(textline + "\r\n");
				}


				// Printing out the board
				if(textline.contains("BOARD IS")){
					bs = textline.replace("."," "); 	
					
					int x = 1;
					while(x <= 9){
						for(int i = 0; i < 3; i++) {
							System.out.println("+---+---+---+");
							System.out.println("|"+(x)+"  |"+(x+1)+"  |" + (x+2) + "  |");
							System.out.println("| " + (bs.charAt(8+x)) + " | " + (bs.charAt(9+x))  + " | " + (bs.charAt(10+x)) + " |");
							System.out.println("|   |   |   |");

							x+=3;
						}
						System.out.println("+---+---+---+");
					}
				}
				
				// As long as the server gives "YOUR TURN" we get to place an input
				winner = textline;
				if(textline.contains("YOUR TURN")){
					System.out.print("Make your move:");
					pw.print(input.next() + "\r\n");
					pw.flush();
				}
				
				// If the server gives information about a winner, we'll stop
				if (textline.contains("WINS")){
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MySocket.close();
	}
}
