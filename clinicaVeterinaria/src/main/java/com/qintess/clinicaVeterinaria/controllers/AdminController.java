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

import com.qintess.clinicaVeterinaria.controllers.Dto.SecretariaDto;
import com.qintess.clinicaVeterinaria.entidades.Secretaria;
import com.qintess.clinicaVeterinaria.services.SecretariaService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private SecretariaService service;

	
	@RequestMapping("/area")
	public String showArea() {
		return "area-admin";
	}
	
	@RequestMapping("/showFormCadastro")
	public String showFormCadastro(Model model) {
		
		model.addAttribute("secretaria", new Secretaria());
		model.addAttribute("secretarias", service.buscarTodos());
		
		return "cadastro-secretaria";
	}
	
	@RequestMapping("/cadastraSecretaria")
	public String cadastraSecretaria(@Valid SecretariaDto secretariaDto, BindingResult result, Model model, RedirectAttributes r) {
		
		
		try {
			Secretaria secretaria = secretariaDto.converter();
			service.insere(secretaria);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormCadastro";
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("secretaria", secretariaDto);
				model.addAttribute("secretarias", service.buscarTodos());
				return "cadastro-secretaria";
			}
			
			r.addFlashAttribute("erro", "Erro: não foi possível cadastrar");
			return "redirect:showFormCadastro";
		}
		
		
		
		
		
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
		var secretariaOptional = service.buscaPorId(id);
		
		if(secretariaOptional.isPresent()) {
			var secretaria = secretariaOptional.get();
			
			var secretariaDto = new SecretariaDto(secretaria);
			
			model.addAttribute("secretaria", secretariaDto);
		}
		
		return "cadastro-secretaria";
	}
	
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/admin/showFormCadastro";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: não foi possível deletar");
			return "redirect:/admin/showFormCadastro";
		}
	}
}

