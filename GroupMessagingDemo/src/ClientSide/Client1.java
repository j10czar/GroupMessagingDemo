package ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {


    private String myIP;
    private int myPort;
    private String myName;

    public Client1(String ip, int port, String name) throws UnknownHostException, IOException, InterruptedException
    {
    

        System.out.println(1);
        myIP = ip;
        myPort = port;
        myName = name;

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        Socket socket = new Socket(myIP,myPort);
		ServerConnector serverOut = new ServerConnector(socket);


        ClientGUI main = new ClientGUI();
        //put gui init here

        System.out.println("Type /quit to leave chatroom");
		System.out.println("Connection established to server");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("/n "+myName);
		out.println("//j");

        new Thread(serverOut).start();

        while(true)
		{
			System.out.println("> ");
			String command = keyboard.readLine();
			
			if(command.equals("/getInfo"))
			{
				System.out.println("Connected to: "+myIP);
				System.out.println("Port: "+ myPort);
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
