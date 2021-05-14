package org.feezor.textapalooza.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Door extends Item {
	
	public enum Orientation {
		
		NORTH("North"),
		SOUTH("South"),
		EAST("East"),
		WEST("West");
		
		private String name;
		
		Orientation(String name){
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
	}
	
	@JsonProperty("RoomIdentifier")
	private String roomId;
	@JsonProperty("Orientation")
	private Orientation orientation;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	

}
