package com.desafiostefanini.service;

import com.desafiostefanini.dto.EnderecoAtualizacaoDTO;
import com.desafiostefanini.dto.EnderecoDTO;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {

    Page<EnderecoDTO> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable);

    EnderecoAtualizacaoDTO atualizar(Long id, EnderecoAtualizacaoDTO enderecoAtualizacaoDTO);

    EnderecoDTO buscarPorId(Long id);

    void remover(Long id);

    void atualizarPropriedadeAtivo(Long id, Boolean ativo);
}
