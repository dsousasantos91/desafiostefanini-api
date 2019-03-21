package com.desafiostefanini.service;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.dto.PessoaCadastroDTO;
import com.desafiostefanini.dto.PessoaDTO;
import com.desafiostefanini.dto.PessoaDetelheDTO;
import com.desafiostefanini.dto.PessoaEnderecoDTO;
import com.desafiostefanini.repository.filter.PessoaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaService {

    PessoaCadastroDTO salvar(PessoaCadastroDTO pessoaCadastroDTO);

    Page<PessoaDTO> pesquisar(PessoaFilter pessoaFilter, Pageable pageable);

    PessoaDTO atualizar(Long id, PessoaDTO pessoaDTO);

    PessoaDetelheDTO buscarPorId(Long id);

    void remover(Long id);

    PessoaEnderecoDTO buscarPessoaEndereco(Long id);

}
