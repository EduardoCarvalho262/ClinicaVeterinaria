package com.qintess.clinicaVeterinaria.controllers.Dto;

import javax.persistence.FetchType;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Exame;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;

public class ExameDto {


	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Veterinario veterinario;
	
	public ExameDto() {}

	public ExameDto(Exame e) {
		this.nome = e.getNome();
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

	public Exame converte() {
		
		Exame e = new Exame(this.nome);
		
		return e;
	}
}
