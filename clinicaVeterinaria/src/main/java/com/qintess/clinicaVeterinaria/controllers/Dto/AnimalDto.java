/**
 * 
 */
package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.entidades.Dono;
import com.qintess.clinicaVeterinaria.entidades.Especie;
import com.qintess.clinicaVeterinaria.entidades.Raca;


public class AnimalDto {
	
	private int id;
	
	@NotNull
	@NotBlank(message = "Erro: campo em branco")
	private String nome;
	
	@NotNull
	@NotBlank(message = "Erro: campo em branco")
	private String especie;
	
	@NotNull
	@NotBlank(message = "Erro: campo em branco")
	private String raca;
	
	@NotNull
	@NotBlank(message = "Erro: campo em branco")
	private String dataNascimento;
	
	private Dono dono;
	
	public AnimalDto() {}

	public AnimalDto(Animal a) {
		this.id = a.getId();
		this.nome = a.getNome();
		this.especie = a.getEspecie().getNome();
		this.raca = a.getRaca().getNome();
		this.dataNascimento = a.getDataNascimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Animal converter() {
		
		Especie e = new Especie(especie);
		
		Raca r = new Raca(raca);
		
		var data = LocalDate.parse(this.dataNascimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Animal animal = new Animal(nome, e, r, data);
		
		return animal;
		
	}
}
