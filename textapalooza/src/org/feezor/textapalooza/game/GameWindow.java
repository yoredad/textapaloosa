package org.feezor.textapalooza.game;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.feezor.textapalooza.game.domain.Game;
import org.feezor.textapalooza.game.domain.Player;
import org.feezor.textapalooza.game.domain.Room;
import org.feezor.textapalooza.utils.FileUtil;
import org.feezor.textapalooza.utils.JSONUtils;

public class GameWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JButton submitBtn;
	private JLabel lblNewLabel;
	private static String gameFile = "resources\\game.json";
	private Game game = null;
	private Room curRoom = null;
	private Player player = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(args.length>0) {
						if(args.length<2) {
							System.out.println("invalid arguments");
							System.exit(-1);
						}
						if("-f".equals(args[0])) {
							gameFile = args[1];
						}
					}
					GameWindow window = new GameWindow(new File(gameFile));
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.exit(-1);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		super();
	}
	
	public GameWindow(File f) {
		initialize(f);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(File f) {
		game = JSONUtils.jsonToObject(FileUtil.readFile(f), Game.class);
		player = new Player();
		curRoom = game.getRooms().get(0);
		
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
		
		lblNewLabel = new JLabel(game.getTitle());
		lblNewLabel.setBounds(40, 11, 862, 38);
		frame.getContentPane().add(lblNewLabel);
		
		// init the display
		textField.setText(curRoom.getDescription());
		if(game.getStartingItems()!=null) {
			player.setItems(game.getStartingItems());
		}
	}
}
