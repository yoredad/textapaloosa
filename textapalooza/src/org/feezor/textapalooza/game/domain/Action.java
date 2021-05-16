package org.feezor.textapalooza.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Action {
	
	@JsonProperty ("Text")
	private String text ;
	
	@JsonProperty ("ItemIdentifier") //the item that was used
	private String itemId ;
	
	@JsonProperty ("RewardItemIdentifier")
	private String rewardId ;
	
	public String getRewardId() {
		return rewardId;
	}
	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
}
