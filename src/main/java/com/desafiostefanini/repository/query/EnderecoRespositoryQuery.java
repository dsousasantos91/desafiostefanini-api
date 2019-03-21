package com.desafiostefanini.repository.query;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoRespositoryQuery {

    Page<Endereco> filtrar(EnderecoFilter enderecoFilter, Pageable pageable);
}
