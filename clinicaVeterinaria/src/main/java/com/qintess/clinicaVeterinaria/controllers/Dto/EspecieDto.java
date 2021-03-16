package com.qintess.clinicaVeterinaria.controllers.Dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;

public class EspecieDto {
	
	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome;
	
	private Veterinario veterinarioEspecializado;
	
	public EspecieDto() {}

	public EspecieDto(String nome) {
		this.nome = nome;
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

	public Veterinario getVeterinarioEspecializado() {
		return veterinarioEspecializado;
	}

	public void setVeterinarioEspecializado(Veterinario veterinarioEspecializado) {
		this.veterinarioEspecializado = veterinarioEspecializado;
	}
}
