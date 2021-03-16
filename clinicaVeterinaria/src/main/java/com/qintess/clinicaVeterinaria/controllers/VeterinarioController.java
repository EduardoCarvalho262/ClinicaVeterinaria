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

import com.qintess.clinicaVeterinaria.controllers.Dto.VeterinarioDto;

import com.qintess.clinicaVeterinaria.entidades.Especialidade;

import com.qintess.clinicaVeterinaria.entidades.Veterinario;
import com.qintess.clinicaVeterinaria.services.EspecialidadeService;
import com.qintess.clinicaVeterinaria.services.VeterinarioService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
	
	@Autowired
	VeterinarioService service;
	
	@Autowired
	EspecialidadeService especialidade;
	
	VeterinarioDto veterinarioSuporte = new VeterinarioDto();
	
	
	@RequestMapping("/area")
	public String home() {
		return "area-veterinario";
	}
	
	
	@RequestMapping("/showFormCadastro")
	public String showFormCadastro(Model model) {
		
		model.addAttribute("veterinario", new Veterinario());
		model.addAttribute("veterinarios", service.buscarTodos());
		
		return "veterinario-cadastro";
	}
	
	@RequestMapping("/cadastra")
	public String cadastraVeterinario(@Valid VeterinarioDto veterinarioDto, BindingResult result,
			Model model, RedirectAttributes r) {
		
		try {
			Veterinario veterinario = veterinarioDto.converter();
			service.insere(veterinario);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormCadastro";
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("veterinario", veterinarioDto);
				model.addAttribute("veterinarios", service.buscarTodos());
				return "veterinario-cadastro";
			}
			
			r.addFlashAttribute("erro", "Erro: não foi possível cadastrar");
			return "redirect:showFormCadastro";
		}
		
		
		
		
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable String id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/veterinario/showFormCadastro";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: não foi possível deletar(Relação existente)");
			return "redirect:/veterinario/showFormCadastro";
		}
		
		
		
		
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("PesquisaAnimal") String searchName, Model model) {
		
		List<Especialidade> listaEspecidades = especialidade.buscaNome(searchName);
		
		model.addAttribute("listaEspecialidades", listaEspecidades);
		
		return "seleciona-especialidades";
	}
	
	
	@RequestMapping("/showSelecionaEspecialidades/{id}")
	public String showSelecionaEspecialidades(@PathVariable String id, Model model) {
		
		Veterinario veterinario = service.buscaPorId(id).get();
		System.out.println(veterinario);
		VeterinarioDto vDto = new VeterinarioDto(veterinario);
		
		veterinarioSuporte = vDto;
		
		model.addAttribute("listaEspecialidades", especialidade.buscarTodos());
		
		return "seleciona-especialidades";
	}
	
	@GetMapping("/adicionaEspecialidade/{id}")
	public String adicionaEspecialidades(@PathVariable int id, Model model) {
		
		
		Especialidade es = especialidade.buscaPorId(id).get();
		System.out.println(es);
		veterinarioSuporte.setEspecialidades(es);
		
		List<Especialidade> especialidadesSelecionadas = veterinarioSuporte.getEspecialidades();
		
		Veterinario v = veterinarioSuporte.converter();
		
		especialidadesSelecionadas.forEach(e -> v.addEspecialidades(e));
		
		service.insere(v);
		
		
		model.addAttribute("listaEspecialidades", especialidade.buscarTodos());
		model.addAttribute("sucesso", "Cadastrado com sucesso");
		
		
		return "seleciona-especialidades";
	}

}
