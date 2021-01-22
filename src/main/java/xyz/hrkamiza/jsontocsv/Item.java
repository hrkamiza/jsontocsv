package xyz.hrkamiza.jsontocsv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Item {
	private TipoN cpf;
	private TipoS dataCadastroCliente;
	private TipoS dataNascimento;
	private TipoS email;
	@SerializedName("nome")
	private TipoS nome;
	@SerializedName("numeroCelular")
	private TipoN numeroCelular;

	@JsonProperty("cpf")
	public TipoN getCpf() {
		return cpf;
	}

	@JsonProperty("cpf")
	public void setCpf(TipoN value) {
		this.cpf = value;
	}

	@JsonProperty("dataCadastroCliente")
	public TipoS getDataCadastroCliente() {
		return dataCadastroCliente;
	}

	@JsonProperty("dataCadastroCliente")
	public void setDataCadastroCliente(TipoS value) {
		this.dataCadastroCliente = value;
	}

	@JsonProperty("dataNascimento")
	public TipoS getDataNascimento() {
		return dataNascimento;
	}

	@JsonProperty("dataNascimento")
	public void setDataNascimento(TipoS value) {
		this.dataNascimento = value;
	}

	@JsonProperty("email")
	public TipoS getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(TipoS value) {
		this.email = value;
	}

	@JsonProperty("nome")
	public TipoS getNome() {
		return nome;
	}

	@JsonProperty("nome")
	public void setNome(TipoS value) {
		this.nome = value;
	}

	@JsonProperty("numeroCelular")
	public TipoN getNumeroCelular() {
		return numeroCelular;
	}

	@JsonProperty("numeroCelular")
	public void setNumeroCelular(TipoN value) {
		this.numeroCelular = value;
	}

	@Override
	public String toString() {
		return "Item [cpf=" + cpf + ", dataCadastroCliente=" + dataCadastroCliente + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", nome=" + nome + ", numeroCelular=" + numeroCelular + "]";
	}

}
