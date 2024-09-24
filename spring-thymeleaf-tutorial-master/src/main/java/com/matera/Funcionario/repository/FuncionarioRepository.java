package com.matera.Funcionario.repository;

import com.matera.Funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Define a classe como um bean do Spring
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { }
//Deve estender JpaRepository e declarar a entidade (Post) e o tipo de chave primária (Long)

