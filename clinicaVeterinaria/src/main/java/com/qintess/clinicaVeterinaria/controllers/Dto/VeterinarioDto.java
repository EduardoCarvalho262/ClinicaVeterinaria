package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.util.ArrayList;
import java.util.List;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Especialidade;
import com.qintess.clinicaVeterinaria.entidades.Exame;
import com.qintess.clinicaVeterinaria.entidades.Tratamento;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;

public class VeterinarioDto {

	private String crmv;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String endereco;
	
	@NotNull
	@NotBlank(message = "Erro: campo em branco")
	private String telefone;
	
	private List<Especialidade> especialidades = new ArrayList<>();
	
	@NotNull
	@NotBlank(message = "Erro: campo em branco")
	private String plantao;
	
	private String diagnostico;
	
	private Tratamento tratamento;
	
	private List<Exame> exames = new ArrayList<>();
	
	public VeterinarioDto() {}

	public VeterinarioDto(Veterinario v) {
		this.crmv = v.getCrmv();
		this.nome = v.getNome();
		this.endereco = v.getEndereco();
		this.telefone = v.getTelefone();
		this.plantao = v.getPlantao() == true ? "Sim" : "Não";
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
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

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Especialidade especialidade) {
		this.especialidades.add(especialidade);
	}

	public String getPlantao() {
		return plantao;
	}

	public void setPlantao(String plantao) {
		this.plantao = plantao;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Tratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}	
	
	public Veterinario converter() {
		
		Boolean plantao = this.plantao.equalsIgnoreCase("Sim") ? true : false;
		
		Veterinario v = new Veterinario(this.crmv, this.nome, this.endereco, this.telefone,plantao);
		
		return v;
		
	}
}
