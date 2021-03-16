package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Atendimento;
import com.qintess.clinicaVeterinaria.repositorios.AtendimentoRepositorio;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepositorio repositorio;
	
	public void insere(Atendimento atendimento) {
		repositorio.save(atendimento);
	}

	public List<Atendimento> buscarTodos() {
		return (List<Atendimento>) repositorio.findAll();
	}

	public void deletaPorId(int id) {
		repositorio.deleteById(id);
	}

	public  Optional<Atendimento> buscaPorId(int id) {
		return repositorio.findById(id) ;
	}
}
