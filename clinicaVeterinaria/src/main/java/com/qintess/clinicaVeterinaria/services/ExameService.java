package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Exame;
import com.qintess.clinicaVeterinaria.repositorios.ExameRepositorio;

@Service
public class ExameService {

	@Autowired
	private ExameRepositorio repositorio;
	
	public void insere(Exame exame) {
		repositorio.save(exame);
	}

	public List<Exame> buscarTodos() {
		return (List<Exame>) repositorio.findAll();
	}

	public void deletaPorId(int id) {
		repositorio.deleteById(id);
	}

	public  Optional<Exame> buscaPorId(int id) {
		return repositorio.findById(id);
	}
}
