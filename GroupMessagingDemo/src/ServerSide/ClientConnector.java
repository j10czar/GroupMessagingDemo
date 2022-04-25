package ServerSide;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientConnector implements Runnable{

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ClientConnector> clients;
	private String username;
	
	public ClientConnector(Socket sock, ArrayList<ClientConnector> c) throws IOException
	{
		client = sock;
		clients = c;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
	}
	
	
	public void run()
	{
		
		try {
			while(true)
			{
				String request = in.readLine();
				
				if(request.startsWith("/n"))
				{
					username = request.substring(3);  //temp
				}
				else if(request.equals("//l"))
				{
					serverOutToAll(username+" has left the chatroom.");
				}
					
				else
				{
					outToAll(request);
				}
			}
			
			
					
		} catch (IOException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			out.close();
		}
			

		
	}
	
	
	private void outToAll(String message)
	{
		for(ClientConnector aClient : clients)
		{
			aClient.out.println("("+username+"): "+message);
		}
	}
	
	public void serverOutToAll(String message) {
		for(ClientConnector aClient : clients)
		{
			aClient.out.println("[SERVER]: "+message);
		}
	}
}
