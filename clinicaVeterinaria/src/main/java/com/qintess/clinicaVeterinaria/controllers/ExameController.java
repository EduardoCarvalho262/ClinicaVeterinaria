package com.qintess.clinicaVeterinaria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.clinicaVeterinaria.controllers.Dto.ExameDto;
import com.qintess.clinicaVeterinaria.entidades.Exame;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;
import com.qintess.clinicaVeterinaria.services.ExameService;
import com.qintess.clinicaVeterinaria.services.VeterinarioService;

@Controller
@RequestMapping("/exame")
public class ExameController {
	
	@Autowired
	private ExameService service;
	
	@Autowired
	private VeterinarioService vetService;
	
	private Exame exameSuporte = new Exame();
	
	@RequestMapping("/showFormExame")
	public String showFormulario(Model model) {
		
		
		model.addAttribute("exames", service.buscarTodos());
		model.addAttribute("exame", new ExameDto());
		
		return "cadastro-exame";
	}
	
	
	
	@RequestMapping("/cadastra")
	public String cadastra(@Valid ExameDto exameDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Exame exame = exameDto.converte();
			service.insere(exame);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormExame";
			
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("exames", service.buscarTodos());
				model.addAttribute("exame", exameDto);
				return "cadastro-exame";
			}
			
			r.addFlashAttribute("erro", "Erro: não foi possível cadastrar");
			return "redirect:showFormExame";
		}	
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/exame/showFormExame";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: Não foi possível deletar(Relação existente)");
			return "redirect:/exame/showFormExame";
		}
		
		
		
		
		
	}
	
	
	
	@RequestMapping("/showSelecionaVeterinario/{id}")
	public String showSelecionaVeterinarios(@PathVariable int id, Model model) {

		Exame e = service.buscaPorId(id).get();
		System.out.println(e);

		exameSuporte = e;

		model.addAttribute("veterinarios", vetService.buscarTodos());

		return "seleciona-veterinario-exame";
	}
	
	
	@RequestMapping("/search")
	public String searchVet(@RequestParam("PesquisaVeterinario") String searchName, Model model) {
		
		List<Veterinario> listaVeterinarios = vetService.buscaNome(searchName);
		
		model.addAttribute("veterinarios", listaVeterinarios);
		
		return "seleciona-veterinario-exame";
	}
	
	
	
	@GetMapping("/adicionaVeterinario/{id}")
	public String adicionaVeterinario(@PathVariable String id, Model model) {
		
		
		Veterinario ve = vetService.buscaPorId(id).get();
		System.out.println(ve);
		
		ve.addExames(exameSuporte);
		
		service.insere(exameSuporte);
		
		vetService.insere(ve);
	
		
		model.addAttribute("veterinarios", vetService.buscarTodos());
		model.addAttribute("sucesso", "Cadastrado com sucesso");
		
		
		return "seleciona-veterinario-exame";
	}
	
	@RequestMapping("/voltaCadastro")
	public String voltarCadastro(Model model) {
		
		model.addAttribute("exames", service.buscarTodos());
		
		return "cadastro-exame";
	}

}
