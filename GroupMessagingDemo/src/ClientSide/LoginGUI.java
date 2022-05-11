package ClientSide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginGUI implements ActionListener{

	private JFrame frame;
	private JTextField ipField;
	private JTextField portField;
	private JTextField nameField;
	private JButton loginBtn;

	/**
	 * Launch the application.
	 */

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
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 173, 45);
		frame.getContentPane().add(lblNewLabel);
		
		ipField = new JTextField();
		ipField.setBounds(143, 55, 190, 20);
		frame.getContentPane().add(ipField);
		ipField.setColumns(10);
		
		portField = new JTextField();
		portField.setBounds(143, 108, 190, 20);
		frame.getContentPane().add(portField);
		portField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(143, 159, 190, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("IP (leave blank for local):");
		lblNewLabel_1.setBounds(10, 58, 131, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Port (leave blank):");
		lblNewLabel_2.setBounds(10, 111, 123, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setBounds(10, 162, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(175, 211, 89, 23);
		frame.getContentPane().add(loginBtn);
		
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
              System.exit(0);
            }
          });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ipField))
		{
			//ip info here
		}
		
	}
}
