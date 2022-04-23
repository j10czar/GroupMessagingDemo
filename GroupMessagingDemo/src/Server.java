import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private static int PORT = 1789;
	private static ArrayList<ClientConnector> clients= new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(5);
	
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket listener = new ServerSocket(PORT);

		
		
		System.out.println("Server IP: "+listener.getLocalSocketAddress());
		System.out.println("Server port: "+PORT);
		
		while(true)
		{
			System.out.println("[SERVER]: Waiting for client connection...");
			Socket client = listener.accept();
			System.out.println("[SERVER]: Connected to "+client.getInetAddress().toString());
			ClientConnector clientThread = new ClientConnector(client, clients);
			clients.add(clientThread);
			pool.execute(clientThread);			
		}
		
		

		
		
		



	}

}
