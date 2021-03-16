package com.qintess.clinicaVeterinaria.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qintess.clinicaVeterinaria.entidades.Animal;

public interface AnimalRepositorio extends CrudRepository<Animal, Integer> {
	public List<Animal> findAllByNome(String firstName);
}
