package org.feezor.textapalooza;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.feezor.textapalooza.game.GameWindow;
import org.feezor.textapalooza.game.domain.Action;
import org.feezor.textapalooza.game.domain.CommandAction;
import org.feezor.textapalooza.game.domain.Door;
import org.feezor.textapalooza.game.domain.Door.Orientation;
import org.feezor.textapalooza.utils.FileUtil;
import org.feezor.textapalooza.utils.JSONUtils;
import org.feezor.textapalooza.game.domain.Game;
import org.feezor.textapalooza.game.domain.Item;
import org.feezor.textapalooza.game.domain.Room;
import org.feezor.textapalooza.game.domain.CommandAction.Command;

public class Textapalooza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting textapalooza...");
		GameWindow gw = new GameWindow();
		gw.main(args);
		
		//genTemplate();
	}
	
	private static void genTemplate() {
		Game game = new Game();
		game.setCredits("YoreDad\n");
		game.setCurrentRoomId("ROOM1");
		game.setDescription("Zoe's Big Adventure Part 1");
		game.setHelp("Try one of:\nLOOK\nSEARCH\nGO\nOPEN\nEXIT\n");
		game.setTitle("Girl We Tryin");
		
		List<Room> rooms = new ArrayList<Room>();
		Room room = new Room();
		room.setId("ROOM1");
		room.setDescription("You are in a dark room.\n  A girl lies prone on the sofa.\n  Her finger is bleeding.");
		room.setName("Family Room");
		
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setId("SOFA");
		item.setDescription("A red sofa");
		item.setName("Sofa");
		items.add(item);
		CommandAction cmdAction = new CommandAction() ;
		cmdAction.setCommand (Command.TALK);
		List <Action> actions = new ArrayList <Action>() ;
		Action action = new Action() ;
		action.setText ("Oh no my finger is bleeding, I feel quite faint! If only I had some cheese, or better yet, a bandAid!") ;
		action.setItemId ("KEY1") ;
		actions.add (action) ;
		cmdAction.setActions(actions);
		List <CommandAction> commandActions = new ArrayList <CommandAction>() ;
		commandActions.add(cmdAction) ;
		item.setCommandActions(commandActions) ;
		
		//KEY
		List <Item> itemList = new ArrayList <Item> () ; //list for girl (contains key)
		Item key = new Item() ;
		key.setId("KEY1") ;
		key.setDescription("She has a phallic shaped key.");
		key.setName("Penis Key") ;
		itemList.add(key) ;
		item.setItems(itemList);
		
		
		
		room.setItems(items);
		
		// DOOR 1
		
		List<Door> doors = new ArrayList<Door>();
		Door door = new Door();
		door.setId("DOOR1");
		door.setDescription("Wood paneled door");
		door.setName("Door");
		door.setOrientation(Orientation.NORTH);
		door.setRoomId("ROOM2");
		
		doors.add(door);
		
		room.setDoors(doors);
		
		rooms.add(room);
		
		// ROOM 2
		
		room = new Room();
		room.setId("ROOM2");
		room.setDescription("You have exited the room and survived!");
		room.setName("Freedom");
		room.setWon(true);
		
		// DOOR 2
		
		door = new Door();
		door.setId("DOOR2");
		door.setDescription("Wood paneled door");
		door.setName("Door");
		door.setOrientation(Orientation.SOUTH);
		door.setRoomId("ROOM1");
		
		doors = new ArrayList<Door>();
		doors.add(door);
		
		room.setDoors(doors);
		
		rooms.add(room);
		
		game.setRooms(rooms);
		
		
		// player starting items
		items = new ArrayList<Item>();
		item = new Item();
		item.setId("FLASHLIGHT");
		item.setDescription("Flashlight");
		item.setName("Flashlight");
		items.add(item);
		
		game.setStartingItems(items);
		
		FileUtil.writeFile(JSONUtils.objectToJson(game), new File("resources\\template.json"));
		
	}

}
