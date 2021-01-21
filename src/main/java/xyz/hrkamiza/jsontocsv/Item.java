package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.*;

public class Item {
    private Cpf cpf;
    private DataCadastroCliente dataCadastroCliente;
    private DataCadastroCliente dataNascimento;
    private DataCadastroCliente email;
    private DataCadastroCliente nome;
    private Cpf numeroCelular;

    @JsonProperty("cpf")
    public Cpf getCpf() { return cpf; }
    @JsonProperty("cpf")
    public void setCpf(Cpf value) { this.cpf = value; }

    @JsonProperty("dataCadastroCliente")
    public DataCadastroCliente getDataCadastroCliente() { return dataCadastroCliente; }
    @JsonProperty("dataCadastroCliente")
    public void setDataCadastroCliente(DataCadastroCliente value) { this.dataCadastroCliente = value; }

    @JsonProperty("dataNascimento")
    public DataCadastroCliente getDataNascimento() { return dataNascimento; }
    @JsonProperty("dataNascimento")
    public void setDataNascimento(DataCadastroCliente value) { this.dataNascimento = value; }

    @JsonProperty("email")
    public DataCadastroCliente getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(DataCadastroCliente value) { this.email = value; }

    @JsonProperty("nome")
    public DataCadastroCliente getNome() { return nome; }
    @JsonProperty("nome")
    public void setNome(DataCadastroCliente value) { this.nome = value; }

    @JsonProperty("numeroCelular")
    public Cpf getNumeroCelular() { return numeroCelular; }
    @JsonProperty("numeroCelular")
    public void setNumeroCelular(Cpf value) { this.numeroCelular = value; }
}
