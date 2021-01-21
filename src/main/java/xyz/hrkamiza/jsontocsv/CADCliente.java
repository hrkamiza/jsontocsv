package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.*;

public class CADCliente {
    private Item item;

    @JsonProperty("Item")
    public Item getItem() { return item; }
    @JsonProperty("Item")
    public void setItem(Item value) { this.item = value; }
}
