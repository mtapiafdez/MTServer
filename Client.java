import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException, InterruptedException {
		Socket s = new Socket("localhost", 23500);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
	
		pr.println("First Client");
		pr.flush();
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		
		System.out.println("Server: " + str);
		
		Thread.sleep(5000);
		pr.println("Other");
		pr.flush();
		Thread.sleep(5000);
		pr.println("Whatever");
		pr.flush();
		Thread.sleep(5000);
		pr.println("SSTOP");
		pr.flush();
		s.close();
	}
}

