package br.com.fiap.beans;

import java.sql.Date;

public class Cliente {
	private String cpf;
    private String nome;
    private Date dataNascimento;
    private char sexo;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;
    
	public Cliente() {
		super();
	}
	public Cliente(String cpf, String nome, Date dataNascimento, char sexo, String telefone, String endereco,
			String email, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
    
    
}