package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class TipoN {
	@SerializedName("N")
    private String n;

    @JsonProperty("N")
    public String getN() { return n; }
    @JsonProperty("N")
    public void setN(String value) { this.n = value; }
	@Override
	public String toString() {
		return "TipoN [n=" + n + "]";
	}
    
    
}
