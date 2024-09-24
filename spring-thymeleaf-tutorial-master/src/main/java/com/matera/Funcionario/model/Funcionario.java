package com.matera.Funcionario.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Funcionario implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String Nome;
	private String CPF;
	private String Salario;
	private String Descricao;
	private double Contavalor;

	@Transient
	private double saldoFinal;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dt_cadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getSalario() {
		return Salario;
	}

	public void setSalario(String salario) {
		Salario = salario;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public double getContavalor() {
		return Contavalor;
	}

	public void setContavalor(double contavalor) {
		Contavalor = contavalor;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
}
