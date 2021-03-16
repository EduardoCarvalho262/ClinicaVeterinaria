package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Tratamento;
import com.qintess.clinicaVeterinaria.repositorios.TratamentoRepositorio;

@Service
public class TratamentoService {
	
	@Autowired
	private TratamentoRepositorio repositorio;
	
	public void insere(Tratamento tratamento) {
		repositorio.save(tratamento);
	}

	public List<Tratamento> buscarTodos() {
		return (List<Tratamento>) repositorio.findAll();
	}

	public Optional<Tratamento> buscaPorId(int id) {
		return repositorio.findById(id);
	}

	public void deletaPorId(int id) {
		repositorio.deleteById(id);
		
	}
}
