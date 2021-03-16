package com.qintess.clinicaVeterinaria.entidades;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity 
public class Tratamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalTime horarioAplicacao;
	
	private Integer quantidade;
	
	private String diagnostico;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "tratamentos")
	private List<Medicamento> medicamentos =  new ArrayList<>();
	
	public Tratamento() {}

	public Tratamento(LocalTime horarioAplicacao, Integer quantidade, String diagnostico) {
		this.horarioAplicacao = horarioAplicacao;
		this.quantidade = quantidade;
		this.diagnostico = diagnostico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getHorarioAplicacao() {
		return horarioAplicacao;
	}

	public void setHorarioAplicacao(LocalTime horarioAplicacao) {
		this.horarioAplicacao = horarioAplicacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}


	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public void addMedicamentos(Medicamento medicamento) {
		medicamentos.add(medicamento);
		medicamento.getTratamentos().add(this);
	}
	
	
}
