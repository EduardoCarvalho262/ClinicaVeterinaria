package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Medicamento;
import com.qintess.clinicaVeterinaria.entidades.Tratamento;

public class MedicamentoDto {
	
	
	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String descricao;
	
	private List<Tratamento> tratamentos;
	
	public MedicamentoDto() {}
	
	public MedicamentoDto(Medicamento m) {
		this.nome = m.getNome();
		this.descricao = m.getDescricao();
	}


	public int getId() {
		return id;
	}

	public void setId(int codigo) {
		this.id = codigo;
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

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}
	
	public Medicamento converte() {
		
		Medicamento med = new Medicamento(this.nome, this.descricao);
		
		return med;
	}
}
