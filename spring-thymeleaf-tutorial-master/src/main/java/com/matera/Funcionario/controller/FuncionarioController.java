package com.matera.Funcionario.controller;

import com.matera.Funcionario.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import com.matera.Funcionario.service.FuncionarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //Define a classe como um bean do Spring
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os posts
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/funcionario");
		List<Funcionario> funcionarios = service.findAll();
		double totalContas = service.calcularTotalContas();

		for (Funcionario funcionario : funcionarios) {
			double salario = Double.parseDouble(funcionario.getSalario().replace(",", "."));
			funcionario.setSaldoFinal(salario - funcionario.getContavalor());
		}
		mv.addObject("posts", funcionarios);
		mv.addObject("totalContas", totalContas);
		mv.addObject("posts", service.findAll());
		
		return mv;
	}
	
	//Vai para tela de adição de post
	@GetMapping("/add")
	public ModelAndView add(Funcionario funcionario) {
		
		ModelAndView mv = new ModelAndView("/funcionarioAdd");
		mv.addObject("post", funcionario);
		
		return mv;
	}
	
	//Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id).get());
	}
	
	//Exclui um post por seu ID e redireciona para a tela principal
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/save")
	public ModelAndView save(Funcionario funcionario, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(funcionario);
		}
		
		service.save(funcionario);
		
		return findAll();
	}




}
