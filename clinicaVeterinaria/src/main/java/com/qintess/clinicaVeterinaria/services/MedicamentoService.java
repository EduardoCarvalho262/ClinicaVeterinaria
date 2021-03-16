package com.qintess.clinicaVeterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Medicamento;
import com.qintess.clinicaVeterinaria.repositorios.MedicamentoRepositorio;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepositorio repositorio;
	
	public void insere(Medicamento medicamento) {
		repositorio.save(medicamento);
	}

	public List<Medicamento> buscarTodos() {
		return (List<Medicamento>) repositorio.findAll();
	}

	public void deletaPorId(int id) {
		repositorio.deleteById(id);
	}

	public List<Medicamento> buscaNome(String searchName) {
		return repositorio.findAllByNome(searchName);
	}

	public Optional<Medicamento> buscaPorId(int id) {
		return repositorio.findById(id);
	}

}
