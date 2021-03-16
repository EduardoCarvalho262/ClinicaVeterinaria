package com.qintess.clinicaVeterinaria.controllers.Dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Secretaria;

public class SecretariaDto {
	
	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome;

	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String endereco;
	

	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String telefone;
	
	public SecretariaDto() {}

	public SecretariaDto(Secretaria s) {
		this.nome = s.getNome();
		this.endereco = s.getEndereco();
		this.telefone = s.getTelefone();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Secretaria converter() {
		
		Secretaria s = new Secretaria(this.nome, this.endereco, this.telefone);
		
		return s;
	}
}
