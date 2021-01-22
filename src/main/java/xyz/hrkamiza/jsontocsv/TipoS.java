package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class TipoS {
	@SerializedName("S")
    private String s;

    @JsonProperty("S")
    public String getS() { return s; }
    @JsonProperty("S")
    public void setS(String value) { this.s = value; }
	@Override
	public String toString() {
		return "TipoS [s=" + s + "]";
	}
    
    
}
