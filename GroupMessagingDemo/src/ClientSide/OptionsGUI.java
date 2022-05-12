package ClientSide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class OptionsGUI {

	private JFrame frame;
	private JTextField textField;


	/**
	 * Create the application.
	 */
	public OptionsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Options");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(6, 6, 115, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Leave");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(67, 118, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Change name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(6, 47, 80, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(102, 41, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
