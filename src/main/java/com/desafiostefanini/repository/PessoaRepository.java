package com.desafiostefanini.repository;

import com.desafiostefanini.domain.Pessoa;
import com.desafiostefanini.repository.query.PessoaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {
	
}
