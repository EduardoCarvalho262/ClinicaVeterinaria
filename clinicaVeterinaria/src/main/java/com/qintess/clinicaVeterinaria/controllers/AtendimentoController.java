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

import com.qintess.clinicaVeterinaria.controllers.Dto.AtendimentoDto;
import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.entidades.Atendimento;

import com.qintess.clinicaVeterinaria.entidades.Veterinario;
import com.qintess.clinicaVeterinaria.services.AnimalService;
import com.qintess.clinicaVeterinaria.services.AtendimentoService;
import com.qintess.clinicaVeterinaria.services.VeterinarioService;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService service;
	
	@Autowired
	private AnimalService anService;
	
	@Autowired
	private VeterinarioService vetService;
	
	private Atendimento atendimentoSuporte = new Atendimento();
	
	@RequestMapping("/showFormCadastro")
	public String showFormCadastro(Model model) {
		
		model.addAttribute("atendimento", new AtendimentoDto());
		model.addAttribute("atendimentos", service.buscarTodos());
		
		return "cadastro-atendimento";
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(@Valid AtendimentoDto atendimentoDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Atendimento atendimento = atendimentoDto.converte();
			service.insere(atendimento);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormCadastro";
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("atendimento", atendimentoDto);
				model.addAttribute("atendimentos", service.buscarTodos());
				return "cadastro-atendimento";
			}
			r.addFlashAttribute("erro", "Erro: não foi possivel cadastrar");
			return "redirect:showFormCadastro";
		}
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/atendimento/showFormCadastro";
		}catch(Exception e){
			r.addFlashAttribute("erro", "Erro: nao foi possivel deletar");
			return "redirect:/atendimento/showFormCadastro";
		}		
	}
	
	@RequestMapping("/showSelecionaAnimal/{id}")
	public String showSelecionaAnimais(@PathVariable int id, Model model) {
		
		Atendimento atendimento = service.buscaPorId(id).get();
		
		atendimentoSuporte = atendimento;
		
		
		model.addAttribute("listaAnimais", anService.buscarTodos());;
		
		return "seleciona-animal-atendimento";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("PesquisaAnimal") String searchName, Model model) {
		
		List<Animal> animaisProcurados = anService.buscaNome(searchName);
		
		model.addAttribute("listaAnimais", animaisProcurados);
		
		return "seleciona-animal-atendimento";
	}
	
	
	@GetMapping("/adicionaAnimal/{id}")
	public String adicionaAnimal(@PathVariable int id, Model model) {
		
		
		Animal animal = anService.buscaPorId(id).get();
		System.out.println(animal);
		atendimentoSuporte.setAnimal(animal);
		
		
		service.insere(atendimentoSuporte);
		
		
		model.addAttribute("listaAnimais", anService.buscarTodos());
		model.addAttribute("sucesso", "Cadastrado com sucesso");
		
		return "seleciona-animal-atendimento";
	}
	
	
	@RequestMapping("/showSelecionaVeterinario/{id}")
	public String showSelecionaVeterinarios(@PathVariable int id, Model model) {

		Atendimento a = service.buscaPorId(id).get();
		System.out.println(a);

		atendimentoSuporte = a;
		
		
		model.addAttribute("tipo", atendimentoSuporte.getTipo());
		model.addAttribute("veterinarios", vetService.buscarTodos());

		return "seleciona-veterinario-atendimento";
	}
	
	
	@RequestMapping("/searchVet")
	public String searchVet(@RequestParam("PesquisaVeterinario") String searchName, Model model) {
		
		List<Veterinario> listaVeterinarios = vetService.buscaNome(searchName);
		
		model.addAttribute("veterinarios", listaVeterinarios);
		
		return "seleciona-veterinario-atendimento";
	}
	
	@GetMapping("/adicionaVeterinario/{id}")
	public String adicionaVeterinario(@PathVariable String id, Model model, RedirectAttributes r) {
		
		
		Veterinario ve = vetService.buscaPorId(id).get();
		System.out.println(ve);
		
		atendimentoSuporte.setVeterinario(ve);
		
		service.insere(atendimentoSuporte);
	
		
		model.addAttribute("veterinarios", vetService.buscarTodos());
		r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
		
		
		return "seleciona-veterinario-atendimento";
	}
	
	
	
	

}
