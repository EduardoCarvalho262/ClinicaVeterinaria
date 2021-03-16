package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.qintess.clinicaVeterinaria.entidades.Especialidade;
import com.qintess.clinicaVeterinaria.repositorios.EspecialidadeRepositorio;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepositorio repositorio;
	
	public void insere(Especialidade espelidade) {
		repositorio.save(espelidade);
	}

	public List<Especialidade> buscarTodos() {
		return (List<Especialidade>) repositorio.findAll();
	}

	public void deletaPorId(int id) {
		repositorio.deleteById(id);
	}

	public List<Especialidade> buscaNome(String nome){
		if(nome != null && nome.trim().length() > 0) {
			return repositorio.findAllByNome(nome);
		}else{
			return buscarTodos();
		}
	}

	public  Optional<Especialidade> buscaPorId(int id) {
		return repositorio.findById(id);
	}

}
