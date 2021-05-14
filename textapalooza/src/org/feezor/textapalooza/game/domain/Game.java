package org.feezor.textapalooza.game.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Game {
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Help")
	private String help;
	@JsonProperty("Credits")
	private String credits;
	@JsonProperty("Rooms")
	private List<Room> rooms;
	@JsonProperty("StartingItems")
	private List<Item> startingItems;
	
	@JsonIgnore
	private String currentRoomId;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Item> getStartingItems() {
		return startingItems;
	}
	public void setStartingItems(List<Item> startingItems) {
		this.startingItems = startingItems;
	}
	public String getCurrentRoomId() {
		return currentRoomId;
	}
	public void setCurrentRoomId(String currentRoomId) {
		this.currentRoomId = currentRoomId;
	}
	
	

}
