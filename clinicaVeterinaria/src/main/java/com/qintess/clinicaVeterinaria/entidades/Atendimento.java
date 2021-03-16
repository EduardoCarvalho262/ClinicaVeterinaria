package com.qintess.clinicaVeterinaria.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate dia;
	
	private LocalTime hora;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Veterinario veterinario;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Animal animal;
	
	private Double custo;
	
	private String tipo;

	public Atendimento() {}
	
	
	public Atendimento(LocalDate dia, LocalTime hora, Double custo, String tipo) {
		this.dia = dia;
		this.hora = hora;
		this.custo = custo;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public LocalDate getDia() {
		return dia;
	}


	public void setDia(LocalDate dia) {
		this.dia = dia;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
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
}
