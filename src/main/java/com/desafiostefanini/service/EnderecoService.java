package com.desafiostefanini.service;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {

    Endereco salvar(Endereco endereco);

    Page<Endereco> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable);

    Endereco atualizar(Long id, Endereco endereco);

    Endereco buscarPorId(Long id);

    void remover(Long id);
}
