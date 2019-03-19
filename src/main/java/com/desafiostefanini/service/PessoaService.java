package com.desafiostefanini.service;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.model.Pessoa;
import com.desafiostefanini.repository.filter.PessoaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa);

    Page<Pessoa> pesquisar(PessoaFilter pessoaFilter, Pageable pageable);

    Pessoa atualizar(Long id, Pessoa pessoa);

    Pessoa buscarPorId(Long id);

    void remover(Long id);

    List<Endereco> buscarEnderecoPessoa(Long id);

}
