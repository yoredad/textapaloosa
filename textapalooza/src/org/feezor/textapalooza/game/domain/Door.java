package org.feezor.textapalooza.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Door extends Item {
	
	public enum Orientation {
		
		NORTH("North", "north"),
		SOUTH("South", "south"),
		EAST("East", "east"),
		WEST("West", "west");
		
		private String name;
		private String code ;
		
		Orientation(String name, String code){
			this.name = name;
			this.code = code ;
		}
		public String getName() {
			return this.name;
		}
		public String getCode () {
			return this.code ;
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
