package org.feezor.textapalooza.game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.feezor.textapalooza.game.domain.Door;
import org.feezor.textapalooza.game.domain.Game;
import org.feezor.textapalooza.game.domain.Item;
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
					e.printStackTrace();
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
		submitBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             parseCommands(textField.getText());
	          }
	       });
		
		frame.getContentPane().add(submitBtn);
		
		lblNewLabel = new JLabel(game.getTitle());
		lblNewLabel.setBounds(40, 11, 862, 38);
		frame.getContentPane().add(lblNewLabel);
		
		// init the display
		textArea.setText(curRoom.getDescription());
		if(game.getStartingItems()!=null) {
			player.setItems(game.getStartingItems());
		}
	}
	
	private void parseCommands(String text) {
		if(text==null) return;
		String s = text.trim();
		if(s.length()==0) return;
		String[] vals = s.split(" ");
//		this.textArea.setText(this.textArea.getText()+"\n"+vals[0]);
		String cmd = vals[0].trim().toLowerCase();
		switch (cmd) {
		case "look":
			this.textArea.setText(curRoom.getDescription());
			this.textArea.setText(this.textArea.getText()+"\nYou see:\n");
			if(curRoom.getItems()!=null && curRoom.getItems().size()>0) {
				for(Item item : curRoom.getItems()) {
					this.textArea.setText(this.textArea.getText()+"\n"+item.getDescription()+ " ["+item.getId()+"]");
				}
			}else {
				this.textArea.setText(this.textArea.getText()+"\nThe room is empty\n");
			}
			if(curRoom.getDoors()!=null && curRoom.getDoors().size()>0) {
				for(Door door : curRoom.getDoors()) {
					this.textArea.setText(this.textArea.getText()+"\n"+door.getDescription() + " on the " + door.getOrientation().getName()+" wall\n");
				}
			}else {
				this.textArea.setText(this.textArea.getText()+"\nThe room has no doors\n");
			}
			break;
		case "inventory":
			this.textArea.setText(curRoom.getDescription());
			this.textArea.setText(this.textArea.getText()+"\nYou have:\n");
			if(player.getItems()!=null && player.getItems().size()>0) {
				for(Item item : player.getItems()) {
					this.textArea.setText(this.textArea.getText()+"\n"+item.getDescription()+ " ["+item.getId()+"]");
				}
			}else {
				this.textArea.setText(this.textArea.getText()+"\nYou have no items\n");
			}
			break;
		case "help":
			this.textArea.setText(this.game.getHelp());
			break;
		case "credits":
			this.textArea.setText(this.game.getCredits());
			break;
		case "search":
			this.textArea.setText(curRoom.getDescription());
			String thing = "";
			if (vals.length>1) thing = vals[1].trim();
			if(curRoom.getItems()!=null && curRoom.getItems().size()>0) {
				boolean found = false;
				for(Item item : curRoom.getItems()) {
					if(item.getId().equalsIgnoreCase(thing)) {
						found=true;
						if(item.hasItems()) {
							this.textArea.setText(this.textArea.getText()+"\nYou find:\n");
							for(Item item2 : item.getItems()) {
								this.textArea.setText(this.textArea.getText()+"\n"+item2.getDescription()+ " ["+item2.getId()+"]");
							}
						}else {
							this.textArea.setText(this.textArea.getText()+"\n" + item.getDescription() + " is empty\n");
						}
						break;
					}
					
				}
				if(!found) {
					this.textArea.setText(this.textArea.getText()+"\nI don't see that item: "+thing+"\n");
				}
			}else {
				this.textArea.setText(this.textArea.getText()+"\nI don't see that item: "+thing+"\n");
			}
			break;
		default:
			this.textArea.setText(curRoom.getDescription());
			this.textArea.setText(this.textArea.getText()+"\nI don't understand the command: "+cmd+"\n");
		}
	}
	
	
}
