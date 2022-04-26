package ServerSide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ServerGUI{
    public ServerGUI(int port, String IP) throws InterruptedException  {
        JFrame frame = new JFrame();
        frame.add( new JLabel("Server Port: "+port+"   IP: "+IP ), BorderLayout.NORTH );

        JTextArea ta = new JTextArea();
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, 60 );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );


        frame.add( new JScrollPane( ta )  );

        frame.pack();
        frame.setVisible( true );
        frame.setSize(800,600);
        frame.setTitle("Group Messaging Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//              System.exit(0);
//            }
//          });


    }
}