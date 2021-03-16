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

import com.qintess.clinicaVeterinaria.controllers.Dto.MedicamentoDto;
import com.qintess.clinicaVeterinaria.entidades.Medicamento;
import com.qintess.clinicaVeterinaria.services.MedicamentoService;

@Controller 
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@RequestMapping("/showFormMedicamento")
	public String showFormCadastro(Model model) {
		
		model.addAttribute("medicamento", new MedicamentoDto());
		model.addAttribute("medicamentos", service.buscarTodos());
		
		return "cadastro-medicamento";
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(@Valid MedicamentoDto medicamentoDto, BindingResult result, Model model, RedirectAttributes r) {
		
		try {
			
			Medicamento medicamento = medicamentoDto.converte();
			service.insere(medicamento);
			r.addFlashAttribute("sucesso", "Cadastrado com sucesso");
			
			return "redirect:showFormMedicamento";
			
		} catch (Exception e) {
			if(result.hasErrors()) {
				model.addAttribute("erro", "Erro: " + result.getAllErrors().get(0).getDefaultMessage());
				model.addAttribute("medicamento", medicamentoDto);
				model.addAttribute("medicamentos", service.buscarTodos());
				return "cadastro-medicamento";
			}
			
			r.addFlashAttribute("erro", "Erro: não foi possivel cadastrar");
			return "redirect:showFormMedicamento";
		}
		
		
		
		
		
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id, RedirectAttributes r) {
		
		try {
			service.deletaPorId(id);
			r.addFlashAttribute("Deletado com sucesso");
			return "redirect:/medicamento/showFormMedicamento";
		} catch (Exception e) {
			r.addFlashAttribute("erro", "Erro: não foi possível deletar");
			return "redirect:/medicamento/showFormMedicamento";
		}	
	}

}
