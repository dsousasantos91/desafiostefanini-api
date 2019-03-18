package com.desafiostefanini.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco atualizar(Long id, Endereco endereco) {
		Endereco enderecoSalvo = this.enderecoRepository.findOne(id);
		BeanUtils.copyProperties(endereco, enderecoSalvo, "id");
		return this.enderecoRepository.save(enderecoSalvo);
	}
}
