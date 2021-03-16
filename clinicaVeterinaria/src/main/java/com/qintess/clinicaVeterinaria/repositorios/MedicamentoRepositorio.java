package com.qintess.clinicaVeterinaria.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qintess.clinicaVeterinaria.entidades.Medicamento;

public interface MedicamentoRepositorio extends CrudRepository<Medicamento, Integer> {
	public List<Medicamento> findAllByNome(String firstName);
}
