package ClientSide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginGUI {

	private JFrame frame;
	private JTextField txtIpleaveBlank;
	private JTextField txtPortleaveBlank;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 173, 45);
		frame.getContentPane().add(lblNewLabel);
		
		txtIpleaveBlank = new JTextField();
		txtIpleaveBlank.setBounds(143, 55, 190, 20);
		frame.getContentPane().add(txtIpleaveBlank);
		txtIpleaveBlank.setColumns(10);
		
		txtPortleaveBlank = new JTextField();
		txtPortleaveBlank.setBounds(143, 108, 190, 20);
		frame.getContentPane().add(txtPortleaveBlank);
		txtPortleaveBlank.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(143, 159, 190, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("IP (leave blank for local):");
		lblNewLabel_1.setBounds(10, 58, 131, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Port (leave blank):");
		lblNewLabel_2.setBounds(10, 111, 123, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setBounds(10, 162, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(175, 211, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
