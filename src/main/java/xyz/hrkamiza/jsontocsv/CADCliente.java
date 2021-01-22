package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class CADCliente {
	@SerializedName("Item")
	private Item item;

	@JsonProperty("Item")
	public Item getItem() {
		return item;
	}

	@JsonProperty("Item")
	public void setItem(Item value) {
		this.item = value;
	}

	@Override
	public String toString() {
		return "CADCliente [item=" + item + "]";
	}

}
