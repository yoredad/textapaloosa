package org.feezor.textapalooza.game.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


class Game {
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

}
