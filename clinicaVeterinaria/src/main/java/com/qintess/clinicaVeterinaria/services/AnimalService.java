package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.repositorios.AnimalRepositorio;


@Service
public class AnimalService {

	@Autowired
	private AnimalRepositorio animalRepositorio;
	
	
	public void insere(Animal animal) {
		animalRepositorio.save(animal); 
	}
	
	
	public List<Animal> buscarTodos(){
		return (List<Animal>) animalRepositorio.findAll();
	}
	
	public Optional<Animal> buscaPorId(int id) {
		return animalRepositorio.findById(id);
	}
	
	public void deletaPorId(int id) {
		animalRepositorio.deleteById(id);
	}
	
	public List<Animal> buscaNome(String nome){
		if(nome != null && nome.trim().length() > 0) {
			return animalRepositorio.findAllByNome(nome);
		}else{
			return buscarTodos();
		}
	}
	
	
	
}
