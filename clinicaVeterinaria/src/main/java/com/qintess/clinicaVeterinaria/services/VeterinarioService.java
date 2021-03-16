package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Veterinario;
import com.qintess.clinicaVeterinaria.repositorios.VeterinarioRepositorio;

@Service
public class VeterinarioService {
	
	@Autowired
	private VeterinarioRepositorio repositorio;
	
	public void insere(Veterinario veterinario) {
		repositorio.save(veterinario);
	}

	public List<Veterinario> buscarTodos() {
		return (List<Veterinario>) repositorio.findAll();
	}

	public void deletaPorId(String id) {
		repositorio.deleteById(id);
	}

	public  Optional<Veterinario> buscaPorId(String id) {
		return repositorio.findById(id);
	}

	public List<Veterinario> buscaNome(String searchName) {
		return repositorio.findAllByNome(searchName);
	}

}
