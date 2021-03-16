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

import com.qintess.clinicaVeterinaria.controllers.Dto.EspecialidadeDto;

import com.qintess.clinicaVeterinaria.entidades.Especialidade;
import com.qintess.clinicaVeterinaria.services.EspecialidadeService;


@Controller
@RequestMapping("/especialidade")
public class EspecialidadeController {
	
	@Autowired
	EspecialidadeService especialidadeService;
	
	
	@RequestMapping("/showFormCadastro")
	public String showFormCadastro(Model model) {
		
		model.addAttribute("especialidade", new Especialidade());
		model.addAttribute("especialidades", especialidadeService.buscarTodos());
		
		return "especialidade-cadastro";
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(@Valid EspecialidadeDto especialidadeDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Especialidade especialidade = especialidadeDto.converter();
			especialidadeService.insere(especialidade);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormCadastro";
			
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("especialidade", especialidadeDto);
				model.addAttribute("especialidades", especialidadeService.buscarTodos());
				return "especialidade-cadastro";
			}
			
			r.addFlashAttribute("erro", "Erro: não foi possivel cadastrar");
			return "redirect:showFormCadastro";
		}
		
		
		
		
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			especialidadeService.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/especialidade/showFormCadastro";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: não foi possivel deletar");
			return "redirect:/especialidade/showFormCadastro";
		}	
	}
}
