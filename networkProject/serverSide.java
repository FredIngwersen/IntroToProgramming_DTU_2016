package networkProject;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class serverSide {
	public static void main (String[] args) throws IOException {

		File file = new File("");
		//System.out.println(generateHeader(file));  // <-- For testing purposes

		// Sets the localhost port
		ServerSocket MyServerSocket = new ServerSocket(8080);

		boolean serverActive = true;
		while (serverActive) {
			// Declaring essential variables for connection & I/O
			Socket clientSocket = MyServerSocket.accept();	
			BufferedReader bir = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
			BufferedOutputStream bos = new BufferedOutputStream(clientSocket.getOutputStream());
			//String header = generateHeader(file);

			String request = bir.readLine();

			// Gets all my files in the directory into an array
			File directory = new File("website/");
			File[] listOfFiles = directory.listFiles();

			// Compares the request to the files
			for (int i = 0; i < listOfFiles.length; i++) {
				if (request.contains(listOfFiles[i].getName()) && listOfFiles[i].isFile()) {
					file = new File(listOfFiles[i].getPath().toString());

					// Checks if the request contains a directory
				} else if (request.contains(listOfFiles[i].getName()) && listOfFiles[i].isDirectory()) {
					File subDirectory = new File(listOfFiles[i].getPath());
					listOfFiles = subDirectory.listFiles();

					// Goes into the subdirectory and creates a pathname 
					for(int j = 0; j < listOfFiles.length; j++){
						file = new File(listOfFiles[j].getPath().toString());
					}

					// If the request contains nothing, goto homepage.html
				} else if(request.length() <= 14){
					file = new File("website\\homepage.html");
				}
			}

			//System.out.println(generateHeader(file));		// <-- For testing purposes

			//pw.write(generateHeader(file));
			pw.flush();

			// Declaring variables for sending bytes of info to the user
			byte[] buffer = new byte[2048];	//byte[] stringByte = header.getBytes();
			boolean readAll = false; int nRead = 0;
			FileInputStream fin = new FileInputStream(file);

			// As long as a file has more information, which has not been sent, send it.
			// Only 2048 bytes are being sent at a time
			while(!readAll) {
				nRead = fin.read(buffer);

				if (nRead == -1) {
					fin.close();
					readAll = true;
				} else {
					for(int i = 0; i < nRead; i++){
						bos.write(buffer[i]);
						bos.flush();
					}
				}
			}
			clientSocket.close();
		}
		MyServerSocket.close();
		serverActive = false;
	}

	public static String generateHeader(File file){

		String NNN;
		// Send request status
		if (file.exists() && file.isFile()) {
			NNN = "200";
		} else {
			NNN = "404";
		}

		String fileString = file.getName(); String extension = "";
		int i = fileString.lastIndexOf(".");

		// Declaring type of file
		if(i > 0){
			extension = fileString.substring(i+1);
		}
		if (extension.contains("html")) {
			extension = "text/" + extension;
		} else {
			extension = "image/" + extension;
		}

		// Declaring current date & time
		SimpleDateFormat gmtFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmtString = gmtFormat.format(Calendar.getInstance().getTime());

		// Return full header
		if (NNN == "404") {
			return "HTTP/1.0 " + NNN + "\n" + "Content-Length: " +
					file.length() + "\n" + gmtString;

		} else {
			return "HTTP/1.0 " + NNN + "\n" + "Content-Length: " +
					file.length() + "\n" + "Content-Type: " + extension + "\n" + gmtString;
		}
	}
}
