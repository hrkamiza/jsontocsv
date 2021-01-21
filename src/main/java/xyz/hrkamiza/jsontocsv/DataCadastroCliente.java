package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.*;

public class DataCadastroCliente {
    private String s;

    @JsonProperty("S")
    public String getS() { return s; }
    @JsonProperty("S")
    public void setS(String value) { this.s = value; }
}
