package com.desafiostefanini.repository.query;

import com.desafiostefanini.domain.Pessoa;
import com.desafiostefanini.repository.filter.PessoaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaRepositoryQuery {

	Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable);
}
