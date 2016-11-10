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
			String[] files = 
					{"website\\billeder.html","website\\billeder2.html","website\\dtulogo.bmp",
					"website\\dtulogo.gif","website\\dtulogo.jpg","website\\dtulogo.png",
					"website\\fejl.html","website\\index.html","website\\lorem.html"};
			
			System.out.println(request);
			
			for(int i = 0; i < files.length; i++){
				if(request.contains(files[i].substring(8, files[i].length()))){
					file = new File(files[i]);
				} else {
					file = new File("website\\homepage.html");
				}
			}

			pw.write(generateHeader(file));
			pw.flush();

			byte[] buffer = new byte[1024];
			//byte[] stringByte = header.getBytes();
			boolean readAll = false;
			int nRead = 0;
			FileInputStream fin = new FileInputStream(file);
			while(readAll == false) {
				nRead = fin.read(buffer);
				if (nRead == -1) {
					fin.close();
					readAll = true;
				} else {
					for (int i = 0; i <= nRead; i++) {
						//bos.write(stringByte);
						bos.write(buffer, 0, nRead);
					}
					bos.flush();
				}
			}
			clientSocket.close();
		}
		MyServerSocket.close();
	}

	public static String generateHeader(File file){
		String NNN;
		if (file.exists() && !file.isDirectory()) {
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
