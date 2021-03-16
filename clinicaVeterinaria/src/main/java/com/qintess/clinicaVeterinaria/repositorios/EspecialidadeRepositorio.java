package com.qintess.clinicaVeterinaria.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qintess.clinicaVeterinaria.entidades.Especialidade;

public interface EspecialidadeRepositorio extends CrudRepository<Especialidade, Integer> {
	public List<Especialidade> findAllByNome(String firstName);
}
