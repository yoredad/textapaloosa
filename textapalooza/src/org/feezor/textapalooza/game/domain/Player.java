package org.feezor.textapalooza.game.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

}
