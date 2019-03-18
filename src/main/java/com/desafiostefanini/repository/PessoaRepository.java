package com.desafiostefanini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiostefanini.model.Pessoa;
import com.desafiostefanini.repository.impl.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {
	
}
