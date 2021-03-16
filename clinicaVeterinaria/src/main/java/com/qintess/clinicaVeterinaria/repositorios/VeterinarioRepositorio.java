package com.qintess.clinicaVeterinaria.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qintess.clinicaVeterinaria.entidades.Veterinario;

public interface VeterinarioRepositorio extends CrudRepository<Veterinario, String> {
	public List<Veterinario> findAllByNome(String nome);
}
