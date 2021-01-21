package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.*;

public class Cpf {
    private String n;

    @JsonProperty("N")
    public String getN() { return n; }
    @JsonProperty("N")
    public void setN(String value) { this.n = value; }
}
