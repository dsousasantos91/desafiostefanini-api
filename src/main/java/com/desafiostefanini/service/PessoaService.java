package com.desafiostefanini.service;

import com.desafiostefanini.domain.Pessoa;
import com.desafiostefanini.dto.*;
import com.desafiostefanini.repository.filter.PessoaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa);

    Page<PessoaDTO> pesquisar(PessoaFilter pessoaFilter, Pageable pageable);

    PessoaDTO atualizar(Long id, PessoaDTO pessoaDTO);

    PessoaDetalheDTO buscarPorId(Long id);

    void remover(Long id);

    PessoaEnderecoDTO buscarPessoaEndereco(Long id);

}
