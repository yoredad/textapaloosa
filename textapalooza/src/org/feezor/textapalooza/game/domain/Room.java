package org.feezor.textapalooza.game.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Room extends Item{
	
	@JsonProperty("Items")
	private List<Item> items;
	@JsonProperty("Doors")
	private List<Door> doors;
	@JsonProperty("WonIndicator")
	private boolean won;

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Door> getDoors() {
		return doors;
	}
	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}

}
