package com.matera.Funcionario.service;

import java.util.List;
import java.util.Optional;

import com.matera.Funcionario.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.Funcionario.repository.FuncionarioRepository;

@Service //Define a classe como um bean do Spring
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos posts inseridos
	public List<Funcionario> findAll() {
		return repository.findAll(); 
	}
	
	//Retorno um post a partir do ID
	public Optional<Funcionario> findOne(Long id) {
		return repository.findById(id);
	}
	
	//Salva ou atualiza um post
	public Funcionario save(Funcionario funcionario) {
		return repository.saveAndFlush(funcionario);
	}
	
	//Exclui um post
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public double calcularTotalContas() {
		List<Funcionario> todosFuncionarios = repository.findAll();
		double total = 0;
		for (Funcionario funcionario : todosFuncionarios) {
			total += funcionario.getContavalor();
		}
		return total;
	}


}
