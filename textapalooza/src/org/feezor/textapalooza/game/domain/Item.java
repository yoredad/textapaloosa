package org.feezor.textapalooza.game.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonProperty("Items")
	private List<Item> items;
	@JsonProperty ("OneTimeUseIndicator")
	private boolean oneTimeUse ;
	@JsonProperty ("CommandActions")
	private List <CommandAction> commandActions ;
	@JsonProperty ("Inspect")
	private String inspect ;
	
	public List<CommandAction> getCommandActions() {
		return commandActions;
	}

	public void setCommandActions(List<CommandAction> commandActions) {
		this.commandActions = commandActions;
	}

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	@JsonIgnore
	public boolean hasItems() {
		return items!=null && items.size()>0;
	}

	public boolean isOneTimeUse() {
		return oneTimeUse;
	}

	public void setOneTimeUse(boolean oneTimeUse) {
		this.oneTimeUse = oneTimeUse;
	}

	public String getInspect() {
		return inspect;
	}

	public void setInspect(String inspect) {
		this.inspect = inspect;
	}
	
}
