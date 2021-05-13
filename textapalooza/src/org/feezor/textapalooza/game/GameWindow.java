package org.feezor.textapalooza.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JButton submitBtn;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
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
	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 986, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 60, 869, 463);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(22, 557, 646, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(678, 554, 105, 32);
		frame.getContentPane().add(submitBtn);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(40, 11, 862, 38);
		frame.getContentPane().add(lblNewLabel);
	}
}
