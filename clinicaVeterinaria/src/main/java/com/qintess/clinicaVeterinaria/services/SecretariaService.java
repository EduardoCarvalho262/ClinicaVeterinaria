package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Secretaria;
import com.qintess.clinicaVeterinaria.repositorios.SecretariaRepositorio;

@Service
public class SecretariaService {
	
	@Autowired
	private SecretariaRepositorio secretariaRepositorio;
	
	
	public void insere(Secretaria secretaria) {
		secretariaRepositorio.save(secretaria);
	}
	
	public List<Secretaria> buscarTodos(){
		return (List<Secretaria>) secretariaRepositorio.findAll();
	}
	
	public Optional<Secretaria> buscaPorId(int id) {
		return secretariaRepositorio.findById(id);
	}
	
	public void deletaPorId(int id) {
		secretariaRepositorio.deleteById(id);
	}

}
