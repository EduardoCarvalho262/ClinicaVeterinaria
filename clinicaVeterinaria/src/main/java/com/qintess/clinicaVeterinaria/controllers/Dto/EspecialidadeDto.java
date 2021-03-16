package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Especialidade;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;

public class EspecialidadeDto {
	
	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome; 
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String descricao;
	
	private List<Veterinario> veterinarios = new ArrayList<>();

	
	public EspecialidadeDto() {}
	
	public EspecialidadeDto(Especialidade e) {
		this.nome = e.getNome();
		this.descricao = e.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(Veterinario veterinario) {
		this.veterinarios.add(veterinario);
	}

	public Especialidade converter() {
		
		Especialidade e = new Especialidade(this.nome, this.descricao);
		
		return e;
	}
}
