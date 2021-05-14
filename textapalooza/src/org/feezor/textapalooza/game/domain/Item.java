package org.feezor.textapalooza.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	@JsonProperty("LockedIndicator")
	private boolean locked;
	@JsonProperty("KeyIdentifier")
	private String keyId;
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

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public boolean isCanTake() {
		return canTake;
	}

	public void setCanTake(boolean canTake) {
		this.canTake = canTake;
	}
	

}
