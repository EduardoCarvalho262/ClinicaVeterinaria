package com.qintess.clinicaVeterinaria.controllers;

import java.util.ArrayList;
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

import com.qintess.clinicaVeterinaria.controllers.Dto.TratamentoDto;

import com.qintess.clinicaVeterinaria.entidades.Medicamento;
import com.qintess.clinicaVeterinaria.entidades.Tratamento;
import com.qintess.clinicaVeterinaria.entidades.Veterinario;
import com.qintess.clinicaVeterinaria.services.MedicamentoService;
import com.qintess.clinicaVeterinaria.services.TratamentoService;
import com.qintess.clinicaVeterinaria.services.VeterinarioService;

@Controller
@RequestMapping("/tratamento")
public class TratamentoController {
	
	@Autowired
	private TratamentoService service;
	
	@Autowired
	private VeterinarioService vetService;
	
	@Autowired
	private MedicamentoService medService;
	
	private Tratamento tratamentoSuporte = new Tratamento();
	
	private List<Medicamento> medicamentosListados = new ArrayList<>();
	
	
	@RequestMapping("/showFormTratamento")
	public String showFormCadastro(Model model) {
		
		model.addAttribute("tratamento", new TratamentoDto());
		model.addAttribute("tratamentos", service.buscarTodos());
		model.addAttribute("medicamentos", medicamentosListados);
		
		
		return "cadastro-tratamento";
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(@Valid TratamentoDto tratamentoDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Tratamento tratameto = tratamentoDto.converte();
			service.insere(tratameto);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormTratamento";
			
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("tratamento", tratamentoDto);
				model.addAttribute("tratamentos", service.buscarTodos());
				model.addAttribute("medicamentos", medicamentosListados);
				return "cadastro-tratamento";
			}
			r.addFlashAttribute("erro", "Erro: não foi possível cadastrar");
			return "redirect:showFormTratamento";
		}	
	}
	
	@RequestMapping("/search")
	public String searchVet(@RequestParam("PesquisaVeterinario") String searchName, Model model) {
		
		List<Veterinario> listaVeterinarios = vetService.buscaNome(searchName);
		
		if(listaVeterinarios.isEmpty()) {
			model.addAttribute("veterinarios", vetService.buscarTodos());
		}else {
			model.addAttribute("veterinarios", listaVeterinarios);
		}
		
		
		
		return "seleciona-veterinarios";
	}
	
	@RequestMapping("/showSelecionaVeterinarios/{id}")
	public String showSelecionaVeterinarios(@PathVariable int id, Model model) {

		Tratamento t = service.buscaPorId(id).get();
		System.out.println(t);

		tratamentoSuporte = t;

		model.addAttribute("veterinarios", vetService.buscarTodos());

		return "seleciona-veterinarios";
	}
	
	
	@GetMapping("/adicionaVeterinario/{id}")
	public String adicionaVeterinario(@PathVariable String id, Model model) {
		
		
		Veterinario ve = vetService.buscaPorId(id).get();
		System.out.println(ve);
		
		ve.setTratamento(tratamentoSuporte);
		
		service.insere(tratamentoSuporte);
		
		vetService.insere(ve);
	
		
		model.addAttribute("veterinarios", vetService.buscarTodos());
		model.addAttribute("sucesso", "Cadastrado com sucesso");
		
		
		
		return "seleciona-veterinarios";
	}
	
	
	@RequestMapping("/showSelecionaMedicamentos/{id}")
	public String showSelecionaMedicamentos(@PathVariable int id, Model model) {

		Tratamento t = service.buscaPorId(id).get();
		System.out.println(t);

		tratamentoSuporte = t;

		model.addAttribute("medicamentos", medService.buscarTodos());

		return "seleciona-medicamentos";
	}
	
	@RequestMapping("/searchMed")
	public String search(@RequestParam("PesquisaMedicamento") String searchName, Model model) {
		
		List<Medicamento> listaMedicamento = medService.buscaNome(searchName);
		
		if(listaMedicamento.isEmpty()) {
			model.addAttribute("medicamentos", medService.buscarTodos());
		}else {
			model.addAttribute("medicamentos", listaMedicamento);
		}
		
		return "seleciona-medicamentos";
	}
	
	

	@GetMapping("/adicionaMedicamento/{id}")
	public String adicionaEspecialidades(@PathVariable int id, Model model) {
		
		
		Medicamento me = medService.buscaPorId(id).get();
		System.out.println(me);
		tratamentoSuporte.addMedicamentos(me);
		

		service.insere(tratamentoSuporte);
		
		model.addAttribute("medicamentos", medService.buscarTodos());
		model.addAttribute("sucesso", "Cadastrado com sucesso");
		medicamentosListados = tratamentoSuporte.getMedicamentos();
		
		
		return "seleciona-medicamentos";
	}
	
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/tratamento/showFormTratamento";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: Não foi possível deletar");
			return "redirect:/tratamento/showFormTratamento";
		}	
	}
	
	

}
