package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Medicamento;
import com.qintess.clinicaVeterinaria.entidades.Tratamento;

public class TratamentoDto {

	
	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String horarioAplicacao;
	
	
	private Integer quantidade;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String diagnostico;
	
	private List<Medicamento> medicamentos =  new ArrayList<>();
	
	
	public TratamentoDto() {}

	public TratamentoDto(Tratamento t) {
		this.horarioAplicacao = t.getHorarioAplicacao().format(DateTimeFormatter.ofPattern("HH:mm"));
		this.quantidade = t.getQuantidade();
		this.diagnostico = t.getDiagnostico();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorarioAplicacao() {
		return horarioAplicacao;
	}

	public void setHorarioAplicacao(String horarioAplicacao) {
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

	public void setMedicamentos(Medicamento medicamento) {
		this.medicamentos.add(medicamento);
	}

	
	public Tratamento converte() {
		
		LocalTime hora = LocalTime.parse(this.horarioAplicacao);
		
		Tratamento t = new Tratamento(hora, this.quantidade, this.diagnostico);
		
		return t;
		
		
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	
}
