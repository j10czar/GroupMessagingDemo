package ServerSide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ServerGUI implements ActionListener{
	
	
	private String command;
	private JTextField commandLine;
	
    public ServerGUI(int port, String IP) throws InterruptedException  {
        JFrame frame = new JFrame();
        frame.add( new JLabel("Server Port: "+port+"   IP: "+IP ), BorderLayout.NORTH );

        JTextArea console = new JTextArea();
        TextAreaOutputStream textoutstream = new TextAreaOutputStream( console, 60 );
        PrintStream printstream = new PrintStream( textoutstream );
        System.setOut( printstream );
        System.setErr( printstream );


		ImageIcon icon = new ImageIcon(this.getClass().getResource("sappicon.png"));

		frame.setIconImage(icon.getImage());

        frame.add( new JScrollPane( console )  );
        frame.pack();
        frame.setSize(800,600);
        frame.setTitle("Group Messaging Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        panel.setLayout(new FlowLayout());
        
        commandLine = new JTextField();
        commandLine.setColumns(50);
        commandLine.setText("Write server commands here, type /help for more info");
        commandLine.addActionListener(this);
        
        panel.add(commandLine);
        panel.setVisible(true);
        frame.add(panel, BorderLayout.SOUTH);
		frame.setPreferredSize(new Dimension(800,600));
        frame.setVisible( true );
        
        
        
        
        
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
              System.exit(0);
            }
          });


    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==commandLine)
		{
			if(commandLine.getText().equals("/help"))
			{

					try {
						printHelp();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
			}
			else command = commandLine.getText();	
		}
		
	}
	
	public boolean isCommand()
	{
		return command!=null;
			
	}
	
	public String getCommand()
	{
		if(isCommand())
		{
			String temp = command;
			command = null;
			return temp;
		}
		else
			return null;

		
	}
	
	private void printHelp() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("Resources/ServerHelp.txt"));
		String line = in.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = in.readLine();
		}
		in.close();
	}
}