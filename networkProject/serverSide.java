package networkProject;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class serverSide {
	public static void main (String[] args) throws IOException {
		File file = new File("");
		//System.out.println(file);
		System.out.println(generateHeader(file));

		ServerSocket MyServerSocket = new ServerSocket(8080);
		boolean serverActive = true;
		while (serverActive == true) {
			Socket clientSocket = MyServerSocket.accept();	
			BufferedReader bir = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
			BufferedOutputStream bos = new BufferedOutputStream(clientSocket.getOutputStream());
			//String header = generateHeader(file);

			String request = bir.readLine();

			File folder = new File("website/");
			File[] listOfFiles = folder.listFiles();
		
			for (int i = 0; i < listOfFiles.length; i++) {
				if (request.contains(listOfFiles[i].getName()) && listOfFiles[i].isFile()) {
					file = new File(listOfFiles[i].getPath().toString());
					
				} else if (request.contains(listOfFiles[i].getName()) && listOfFiles[i].isDirectory()) {
					File subFolder = new File(listOfFiles[i].getPath());
					listOfFiles = subFolder.listFiles();
					
					for(int j = 0; j < listOfFiles.length; j++){
						file = new File(listOfFiles[j].getPath().toString());
					}
					
				} else if(request.length() <= 14){
					file = new File("website\\homepage.html");
				}
			}
			
			System.out.println(request);

			//pw.write(generateHeader(file));
			pw.flush();

			byte[] buffer = new byte[2048];
			//byte[] stringByte = header.getBytes();
			boolean readAll = false;
			int nRead = 0;
			FileInputStream fin = new FileInputStream(file);

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
		if (file.exists() && file.isDirectory()) {
			NNN = "200";
		} else {
			NNN = "404";
		}
		String fileString = file.toString();
		String extension = "";
		int i = fileString.lastIndexOf(".");
		if(i > 0){
			extension = fileString.substring(i+1);
		}
		if (extension.contains("html")) {
			extension = "text/" + extension;
		} else {
			extension = "image/" + extension;
		}
		String gmtString = "";
		SimpleDateFormat gmtFormat;
		gmtFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		gmtString = gmtFormat.format(Calendar.getInstance().getTime());
		if (NNN == "404") {
			return "HTTP/1.0 " + NNN + "\n" + "Content-Length: " + file.length() + "\n" + gmtString;
		} else {
			return "HTTP/1.0 " + NNN + "\n" + "Content-Length: " + file.length() + "\n" + "Content-Type: " + extension + "\n" + gmtString;
		}
	}
}
