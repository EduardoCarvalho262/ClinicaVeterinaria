package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.entidades.Atendimento;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;

public class AtendimentoDto {
	
	private int id;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String dia;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String hora;
	
	private Veterinario veterinario;
	

	private Animal animal;
	
	private Double custo;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String tipo;

	public AtendimentoDto() {}
	
	
	public AtendimentoDto(Atendimento a) {
		this.dia = a.getDia().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.hora = a.getHora().format(DateTimeFormatter.ofPattern("HH:mm"));
		this.custo = a.getCusto();
		this.tipo = a.getTipo();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Atendimento converte() {
		
		var dia = LocalDate.parse(this.dia,DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		var hora = LocalTime.parse(this.hora);
		
		return new Atendimento(dia, hora, this.custo, this.tipo);
		
	}

}
