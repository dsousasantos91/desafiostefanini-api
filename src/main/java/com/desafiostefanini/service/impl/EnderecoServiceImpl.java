package com.desafiostefanini.service.impl;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.repository.EnderecoRepository;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import com.desafiostefanini.service.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco salvar(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	@Override
	public Page<Endereco> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable) {
		return this.enderecoRepository.filtrar(enderecoFilter, pageable);
	}

	@Override
	public Endereco atualizar(Long id, Endereco endereco) {
		Endereco enderecoSalvo = this.enderecoRepository.findOne(id);
		BeanUtils.copyProperties(endereco, enderecoSalvo, "id");
		return this.enderecoRepository.save(enderecoSalvo);
	}

	@Override
	public Endereco buscarPorId(Long id) {
		return null;
	}

	@Override
	public void remover(Long id) {

	}
}
