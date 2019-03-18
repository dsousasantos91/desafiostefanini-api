package com.desafiostefanini.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.model.Pessoa;
import com.desafiostefanini.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long pessoaId, Pessoa pessoa) {
		Pessoa pessoaSalva = this.buscarPorId(pessoaId);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return this.pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPorId(Long pessoaId) {
		Pessoa pessoaSalva = pessoaRepository.findOne(pessoaId);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	public List<Endereco> buscarEnderecoPorPessoa(Long pessoaId) {
		Pessoa pessoaSalva = pessoaRepository.findOne(pessoaId);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva.getEnderecos();
	}
	
	
}
