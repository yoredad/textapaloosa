package org.feezor.textapalooza.game.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandAction {
	public enum Command {
		
		LOOK("Look") ,
		USE("Use") ,
		SEARCH("Search"),
		LOOT ("Loot") ,
		HELP ("Help"),
		TALK ("Talk"),
		CREDITS ("Credits") ,
		NORTH("North"),
		SOUTH("South"),
		EAST("East"),
		WEST("West");
		
		private String name;
		
		Command(String name){
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
	}
	
	@JsonProperty ("Command")
	private Command command ;
	@JsonProperty ("Actions")
	private List <Action> actions ;
	
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}