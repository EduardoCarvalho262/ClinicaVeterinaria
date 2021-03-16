package com.qintess.clinicaVeterinaria.controllers.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.entidades.Dono;



public class DonoDto {
	
	private String cpf;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String nome;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String endereco;
	
	@NotBlank(message = "Erro: campo em branco")
	@NotNull
	private String telefone;
	
	private Animal animal;
	
	private List<Animal> animaisDto = new ArrayList<Animal>();
	
	
	
	
	public DonoDto() {}

	public DonoDto(Dono d) {
		this.cpf = d.getCpf();
		this.nome = d.getNome();
		this.endereco = d.getEndereco();
		this.telefone = d.getTelefone();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animaisDto.add(animal);
	}

	public List<Animal> getAnimaisDto() {
		return animaisDto;
	}

	public Dono converte() {
		
		Dono d = new Dono(this.cpf, this.nome, this.endereco, this.telefone);
		
		return d;
	}
}
