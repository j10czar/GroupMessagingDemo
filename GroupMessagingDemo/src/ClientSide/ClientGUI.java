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
  private BufferedReader keyboard;
  private PrintWriter out;
  private JButton options;

  public ClientGUI(String ip, int port, String name) throws InterruptedException, UnknownHostException, IOException  {
        System.out.println(1);
        myIP = ip;
        myPort = port;
        myName = name;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        Socket socket = new Socket(myIP,myPort);
	      ServerConnector serverOut = new ServerConnector(socket);


        // ClientGUI main = new ClientGUI();
        initalize();
        //put gui init here
        System.out.println("--- Welcome to the chatroom! ---");
        System.out.println("Type /help for help");

            out = new PrintWriter(socket.getOutputStream(), true);
		    out.println("/n "+myName);
	    	out.println("//j");

        new Thread(serverOut).start();

  
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

        options = new JButton("Options");
        panel.add(options,BorderLayout.EAST);



          //add options button here
        
        
        
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
			String command = commandLine.getText();
			
			if(command.equals("/getInfo"))
			{
				System.out.println("Connected to: "+myIP);
				System.out.println("Port: "+ myPort);
			}
			else if(commandLine.getText().equals("/help"))
			{

					try {
						printHelp();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
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
	
	
	private void printHelp() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("Resources/ClientHelp.txt"));
		String line = in.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = in.readLine();
		}
		in.close();
	}
}