package com.qintess.clinicaVeterinaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.clinicaVeterinaria.entidades.Especie;
import com.qintess.clinicaVeterinaria.repositorios.EspecieRepositorio;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepositorio especieRepositorio;

	public List<Especie> getEspecies(){
		return (List<Especie>) especieRepositorio.findAll();
	}
	
	
	public void insere(Especie especie) {
		especieRepositorio.save(especie);
	}
}
