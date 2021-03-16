package com.qintess.clinicaVeterinaria.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Veterinario {
	
	@Id
	@Column(length = 8)
	private String crmv;
	
	@Column(length = 50)
	private String nome;
	

	@Column(length = 70)
	private String endereco;
	
	
	@Column(length = 15)
	private String telefone;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "veterinarios")
	private List<Especialidade> especialidades = new ArrayList<>();
	
	private Boolean plantao;
	
	private String diagnostico;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Tratamento tratamento;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "veterinario", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List<Exame> exames = new ArrayList<>();
	
	public Veterinario() {}

	public Veterinario(String crmv, String nome, String endereco, String telefone, Boolean plantao) {
		this.crmv = crmv;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.plantao = plantao;
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

	public String getEspecialidades() {
		return "" + especialidades.size();
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Boolean getPlantao() {
		return plantao;
	}

	public void setPlantao(Boolean plantao) {
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
	
	public void addEspecialidades(Especialidade especialidade) {
		especialidades.add(especialidade);
		especialidade.getVeterinarios().add(this);
	}
	
	public void addExames(Exame exame) {
		exames.add(exame);
		exame.setVeterinario(this);
	}
	
}
