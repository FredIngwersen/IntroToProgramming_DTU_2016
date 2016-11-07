package networkProject;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class serverSide {

	public static void main(String[] args) {
		boolean client = true;

		ServerSocket MyServerSocket = null;
		try {
			MyServerSocket = new ServerSocket(80);


			while(client == true){
				BufferedInputStream bis;
				BufferedOutputStream bos;


				Socket clientSocket = MyServerSocket.accept();

				BufferedReader bir = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));

				PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());

				bis = new BufferedInputStream(clientSocket.getInputStream());
				bos = new BufferedOutputStream(clientSocket.getOutputStream());


				String uri = bir.toString();
				String request = bir.readLine().substring(4, uri.length()-4);
				File fil = new File(request);



				byte[] buffer = new byte[1024];
				boolean readAll = true;
				int nRead = 0;
				FileInputStream fin = new FileInputStream(fil);

				pw.write(generateHeader(fil));

				while (readAll == true) {
					nRead = fin.read(buffer);
					
					if (nRead == -1) {
						fin.close();
						readAll = false;
					} else {
						for(int i = 0; i <= nRead - 1; i++) {
							bos.write(buffer, 0, nRead);

						}
						bos.flush();
					}
				}


				clientSocket.close();
				client = false;
			}
			MyServerSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// HEADER
	public static String generateHeader(File fil){
		String NNN;
		if (fil.exists()) {
			NNN = "200";
		} else {
			NNN = "404";
		}
		String file = fil.toString();
		String extension = "";
		int i = file.lastIndexOf(".");
		if(i > 0){
			extension = file.substring(i+1);
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



		return "HTTP/1.0 " + NNN + "\n" + "Content-Length: " + fil.length() + "\n" + "Content-Type: " + extension + "\n" + gmtString;



	}

}
