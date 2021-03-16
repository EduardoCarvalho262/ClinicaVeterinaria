package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Dono;
import com.qintess.clinicaVeterinaria.repositorios.DonoRepositorio;

@Service
public class DonoService {
	
	@Autowired
	private DonoRepositorio donoRepositorio;
	
	public void insere(Dono dono) {
		donoRepositorio.save(dono);
	}
	
	public List<Dono> buscarTodos(){
		return (List<Dono>) donoRepositorio.findAll();
	}
	
	public void deletaPorId(String id) {
		donoRepositorio.deleteById(id);
	}
	
	public Optional<Dono> buscaPorId(String id) {
		return donoRepositorio.findById(id);
	}
}
