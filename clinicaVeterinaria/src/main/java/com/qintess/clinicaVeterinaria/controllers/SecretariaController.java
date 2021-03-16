package com.qintess.clinicaVeterinaria.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.clinicaVeterinaria.controllers.Dto.AnimalDto;

import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.repositorios.AnimalRepositorio;
import com.qintess.clinicaVeterinaria.services.AnimalService;



@Controller
@RequestMapping("/secretaria")
public class SecretariaController {
	
	@Autowired
	private AnimalService service;
	
	@Autowired
	private AnimalRepositorio animalR;
	

	
	@RequestMapping("/area")
	public String home() {
		return "area-secretaria";
	}
	
	
	@RequestMapping("/showForm")
	public String showFormulario(Model model) {
		
		
		model.addAttribute("animais", service.buscarTodos());
		model.addAttribute("animal", new AnimalDto());
		
		return "cadastra-animal";
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(@Valid AnimalDto animalDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Animal animal = animalDto.converter();
			animalR.save(animal);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			return "redirect:showForm";
			
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("animal", animalDto);
				model.addAttribute("animais", service.buscarTodos());
				return "cadastra-animal";
			}
			r.addFlashAttribute("erro", "Erro: não foi possível inserir");
			return "redirect:showForm";
		}
		
		
		
		
		
		
	}
	
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
			var animal = animalR.findById(id).get();
		
//		if(animalOptional.isPresent()) {
//			var animal = animalOptional.get();
//			
			var animalDto = new AnimalDto(animal);
//			
			model.addAttribute("animal", animalDto);
//		}
		
		return "cadastra-animal";
	}
	
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/secretaria/showForm";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: esse animal tem relação com algum serviço");
			return "redirect:/secretaria/showForm";
		}	
	}
}
