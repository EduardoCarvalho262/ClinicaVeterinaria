package com.qintess.clinicaVeterinaria.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Dono {
	
	@Id
	@Column(length = 11)
	private String cpf;
	
	@NotBlank
	@NotNull
	@Column(length = 60)
	private String nome;
	
	@NotBlank
	@NotNull
	@Column(length = 80)
	private String endereco;
	
	@NotBlank
	@NotNull
	@Column(length = 15)
	private String telefone;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dono", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Animal> animais = new ArrayList<>();
	
	
	public Dono() {}

	public Dono(String cpf, String nome, String endereco, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
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

	public String getAnimais() {
		return "" + animais.size();
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public void addAnimais(Animal animal) {
		animais.add(animal);
		animal.setDono(this);
	}

	@Override
	public String toString() {
		return "Dono [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone +"]";
	}
	
	public List<Animal> mostrarLista() {
		return animais;
	}


	
	
	
}
