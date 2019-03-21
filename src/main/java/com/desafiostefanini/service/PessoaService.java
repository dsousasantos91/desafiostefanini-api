package com.desafiostefanini.service;

import com.desafiostefanini.dto.*;
import com.desafiostefanini.repository.filter.PessoaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    PessoaCadastroDTO salvar(PessoaCadastroDTO pessoaCadastroDTO);

    Page<PessoaDTO> pesquisar(PessoaFilter pessoaFilter, Pageable pageable);

    PessoaAtualizacaoDTO atualizar(Long id, PessoaAtualizacaoDTO pessoaAtualizacaoDTO);

    PessoaDetelheDTO buscarPorId(Long id);

    void remover(Long id);

    PessoaEnderecoDTO buscarPessoaEndereco(Long id);

}
