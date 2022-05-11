package ClientSide;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginGUI implements ActionListener{

	private JFrame frame;
	private JTextField ipField;
	private JTextField portField;
	private JTextField nameField;
	private JButton loginBtn;

	private String myIP = "localhost";
	private int myPort = 1789;
	private String myName = "Anonymous";

	private boolean login = false;

	/**
	 * Launch the application.
	 */

	 public static void main(String[] args)
	 {
		 LoginGUI test = new LoginGUI();
	 }

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon(this.getClass().getResource("appicon.jpg"));

		frame.setIconImage(icon.getImage());

		frame.setTitle("Group Messaging Application (Beta)");

		frame.pack();
		frame.setSize(400,300);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 173, 45);
		frame.getContentPane().add(lblNewLabel);

		JLabel helpLbl = new JLabel(" Leave ip and port blank if running local");
		helpLbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		helpLbl.setBounds(150, 11, 200, 45);
		frame.getContentPane().add(helpLbl);
		
		ipField = new JTextField();
		ipField.setBounds(143, 55, 190, 20);
		frame.getContentPane().add(ipField);
		ipField.setColumns(10);
		ipField.addActionListener(this);
		
		portField = new JTextField();
		portField.setBounds(143, 108, 190, 20);
		frame.getContentPane().add(portField);
		portField.setColumns(10);
		portField.addActionListener(this);
		
		nameField = new JTextField();
		nameField.setBounds(143, 159, 190, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		nameField.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setBounds(10, 58, 131, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setBounds(10, 111, 123, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setBounds(10, 162, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(175, 211, 89, 23);
		frame.getContentPane().add(loginBtn);
		loginBtn.addActionListener(this);

		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            //   System.exit(0);
            }
          });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ipField))
		{
			myIP = ipField.getText();
		}

		if(e.getSource().equals(portField))
		{
			myPort = Integer.parseInt(portField.getText());
		}
		
		if(e.getSource().equals(nameField))
		{
			myName = nameField.getText();
		}
		
		else
		{
			//here we go lol
			//add client 1 which chains to client gui
			//set this window to be invisible

			frame.setVisible(false);

			try {
				ClientGUI app = new ClientGUI(myIP, myPort, myName);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				showMessageDialog(null, "Error launching application");
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				showMessageDialog(null, "Error launching application");
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				showMessageDialog(null, "Error launching application");
				e1.printStackTrace();
			}


		}
	}


}
