package ClientSide;

import javax.swing.*;

import ServerSide.TextAreaOutputStream;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ClientGUI implements ActionListener{
	
	
	private String command;
	private JTextField commandLine;
	
    public ClientGUI() throws InterruptedException  {
        JFrame frame = new JFrame();
        frame.add( new JLabel("Welcome to the chatroom!"), BorderLayout.NORTH );

        ImageIcon icon = new ImageIcon(this.getClass().getResource("appicon.jpg"));

		    frame.setIconImage(icon.getImage());

        JTextArea console = new JTextArea();
        TextAreaOutputStream textoutstream = new TextAreaOutputStream( console, 60 );
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