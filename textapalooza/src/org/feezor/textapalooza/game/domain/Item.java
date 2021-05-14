package org.feezor.textapalooza.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	@JsonProperty("Identifier")
	private String id;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("CanTakeIndicator")
	private boolean canTake;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
