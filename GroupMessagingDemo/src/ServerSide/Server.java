package ServerSide;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {
	
	// add username to connected to screen
	// add port change command
	// add text input box
	

	private static int PORT = 1789;
	private static ArrayList<ClientConnector> clients= new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(5);
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket listener = new ServerSocket(PORT);
		
		ServerGUI sgui = new ServerGUI(PORT, InetAddress.getLocalHost().toString());

		
		while(true)
		{
			System.out.println("[SERVER]: Waiting for client connection...");
			Socket client = listener.accept();
			System.out.println("[SERVER]: Connected to "+client.getInetAddress().toString());
			ClientConnector clientThread = new ClientConnector(client, clients);
			clients.add(clientThread);
			pool.execute(clientThread);
			
			if(sgui.isCommand())
			{
				if(sgui.getCommand().equals("command here"))
				{
					
				}
			}
		}
		
		

		
		
		



	}

}
