package com.matera.Funcionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FuncionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioApplication.class, args);
	}
}
