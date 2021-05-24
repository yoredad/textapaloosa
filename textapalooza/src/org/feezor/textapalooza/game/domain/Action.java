package org.feezor.textapalooza.game.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Action {
	
	@JsonProperty ("Text")
	private String text ;
	
	@JsonProperty ("ItemIdentifier") //the item that was used
	private String itemId ;
	
	@JsonProperty ("RewardItemIdentifier")
	private String rewardId ;
	
	@JsonProperty ("OneTimeUseIndicator")
	private boolean oneTimeUse ;
	
	@JsonProperty ("ActionCompleted")
	private boolean actionCompleted ;
	
	public boolean isOneTimeUse() {
		return oneTimeUse;
	}
	public void setOneTimeUse(boolean oneTimeUse) {
		this.oneTimeUse = oneTimeUse;
	}
	public boolean isActionCompleted() {
		return actionCompleted;
	}
	public void setActionCompleted(boolean actionCompleted) {
		this.actionCompleted = actionCompleted;
	}
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
