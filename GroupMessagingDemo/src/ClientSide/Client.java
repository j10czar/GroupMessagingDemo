package ClientSide;
import java.io.BufferedReader;
// import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
// import java.util.Scanner;

public class Client {
	
	//To do:
	//make gui
	//add connection failed popups

	
	private static int SERVER_PORT = 1789;
	private static String SERVER_IP = "localhost";
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
		
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//		login gui will replace this
		
		 LoginGUI login = new LoginGUI();
		 
//		 System.out.println("----Group Messaging Demo----");
//		 System.out.println("By Jason Tenczar");
//		 System.out.println("Are you running local? (y/n)");
//		 String ans = keyboard.readLine();
//		 if(ans.equals("n"))
//		 {
//		 	System.out.println("Port: ");
//		 	int port = Integer.parseInt(keyboard.readLine());
//		 	SERVER_PORT = port;
//		 	System.out.println("IP address: ");
//		 	String ip = keyboard.readLine();
//		 	SERVER_IP = ip;
//		 }
		 
//		SERVER_PORT = port;
//		SERVER_IP = ip;
		String name = keyboard.readLine();

		name = "Admin";
		
		Socket socket = new Socket(SERVER_IP,SERVER_PORT);
		ServerConnector serverOut = new ServerConnector(socket);

		ClientGUI app = new ClientGUI();
		
		System.out.println("Type /quit to leave chatroom");
		System.out.println("Connection established to server");



		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("/n "+name);
		out.println("//j");
		
		
		new Thread(serverOut).start();
		
		
		while(true)
		{
			System.out.println("> ");
			String command = keyboard.readLine();
			
			if(command.equals("/getInfo"))
			{
				System.out.println("Connected to: "+SERVER_IP);
				System.out.println("Port: "+SERVER_PORT);
			}
			else if(command.equals("/quit"))
			{
				out.println("//l");
				System.exit(0);
			}
			else
				out.println(command);

			

 		}
	}
	
	

}
