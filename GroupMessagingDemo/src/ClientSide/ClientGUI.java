package ClientSide;

import javax.swing.*;

import ServerSide.TextAreaOutputStream;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGUI implements ActionListener{
	
	
	private String command;
	private JTextField commandLine;
  private String myIP;
  private int myPort;
  private String myName;

  public ClientGUI(String ip, int port, String name) throws InterruptedException, UnknownHostException, IOException  {
        System.out.println(1);
        myIP = ip;
        myPort = port;
        myName = name;

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        Socket socket = new Socket(myIP,myPort);
	      ServerConnector serverOut = new ServerConnector(socket);


        // ClientGUI main = new ClientGUI();
        initalize();
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




	
    public void initalize(){
        JFrame frame = new JFrame();

        ImageIcon icon = new ImageIcon(this.getClass().getResource("appicon.jpg"));

		    frame.setIconImage(icon.getImage());

        JTextArea console = new JTextArea();
        ClientTextAreaOutputStream textoutstream = new ClientTextAreaOutputStream( console, 60 );
        PrintStream printstream = new PrintStream( textoutstream );
        System.setOut( printstream );
        System.setErr( printstream );


        frame.add( new JScrollPane( console )  );
        frame.pack();
        frame.setVisible( true );
        frame.setSize(800,600);
        frame.setTitle("Group Messaging Application (Beta)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        panel.setLayout(new FlowLayout());
        
        commandLine = new JTextField();
        commandLine.setColumns(50);
        commandLine.setText("type message here");
        commandLine.addActionListener(this);
        
        panel.add(commandLine);
        panel.setVisible(true);
        frame.add(panel, BorderLayout.SOUTH);
		    frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        
        
        
        
        
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
              System.exit(0);
            }
          });


    }

	@Override
	public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(commandLine))
        {
            System.out.println("Command received");


        }
	

		
	}
}