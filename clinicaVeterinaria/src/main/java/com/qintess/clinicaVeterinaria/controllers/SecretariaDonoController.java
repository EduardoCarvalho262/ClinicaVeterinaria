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

import com.qintess.clinicaVeterinaria.controllers.Dto.DonoDto;
import com.qintess.clinicaVeterinaria.entidades.Animal;
import com.qintess.clinicaVeterinaria.entidades.Dono;
import com.qintess.clinicaVeterinaria.services.AnimalService;
import com.qintess.clinicaVeterinaria.services.DonoService;

@Controller
@RequestMapping("/secretariaDono")
public class SecretariaDonoController {
	
	@Autowired
	private DonoService donoService;
	
	@Autowired
	private AnimalService anService;
	
	private DonoDto DonoSuporte = new DonoDto();
	
	@RequestMapping("/showFormDono")
	public String showFormularioDono(Model model) {
		
		
		
		DonoDto donoDto = new DonoDto();
		
		model.addAttribute("donos", donoService.buscarTodos());
		model.addAttribute("dono", donoDto);

		
		return "dono/cadastro-dono";
	}
	
	@RequestMapping("/showSelecionaAnimais/{id}")
	public String showSelecionaAnimais(@PathVariable String id, Model model) {
		
		Dono dono = donoService.buscaPorId(id).get();
		DonoDto donoDto = new DonoDto(dono);
		
		DonoSuporte = donoDto;
		
		model.addAttribute("listaAnimais", anService.buscarTodos());;
		
		return "dono/seleciona-animais";
	}
	
	@RequestMapping("/cadastraDono")
	public String cadastraDono(@Valid DonoDto donoDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Dono dono = donoDto.converte();
			donoService.insere(dono);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormDono";
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("donos", donoService.buscarTodos());
				model.addAttribute("dono", donoDto);;
				return "cadastra-animal";
			}
			
			r.addFlashAttribute("erro", "Erro: não foi possivel inserir");
			return "redirect:/secretariaDono/showFormDono";
		}
		
		
		
		
		
		
		
		
	}
	
	@RequestMapping("/deletaDono/{id}")
	public String deletaDono(@PathVariable String id, RedirectAttributes r) {
		try {
			donoService.deletaPorId(id); 
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/secretariaDono/showFormDono";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: esse dono tem relação com algum serviço");
			return "redirect:/secretariaDono/showFormDono";
		}
	}
	
	@GetMapping("/editaDono/{id}")
	public String edita(@PathVariable String id, Model model) {
		
		var donoOptional = donoService.buscaPorId(id);
		
		if(donoOptional.isPresent()) {
			var dono = donoOptional.get();
			
			var donoDto = new DonoDto(dono);
			
			model.addAttribute("dono", donoDto);
		}
		
		return "dono/cadastro-dono";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("PesquisaAnimal") String searchName, Model model) {
		
		List<Animal> animaisProcurados = anService.buscaNome(searchName);
		
		model.addAttribute("listaAnimais", animaisProcurados);
		
		return "dono/seleciona-animais";
	}
	
	
	@GetMapping("/adicionaAnimal/{id}")
	public String adicionaAnimal(@PathVariable int id, Model model) {
		
		
		Animal animal = anService.buscaPorId(id).get();
		System.out.println(animal);
		DonoSuporte.setAnimal(animal);
		
		
		List<Animal> animaisAdicionados = DonoSuporte.getAnimaisDto();
		
		Dono dono = DonoSuporte.converte();
		animaisAdicionados.forEach(a -> dono.addAnimais(a));
		
		
		donoService.insere(dono);
		
		
		model.addAttribute("listaAnimais", anService.buscarTodos());
		model.addAttribute("sucesso", "Cadastrado com sucesso");
		
		return "dono/seleciona-animais";
	}
	
	@RequestMapping("/voltaCadastro")
	public String voltarCadastro(Model model) {
		
		model.addAttribute("donos", donoService.buscarTodos());
		
		return "dono/cadastro-dono";
	}

}
