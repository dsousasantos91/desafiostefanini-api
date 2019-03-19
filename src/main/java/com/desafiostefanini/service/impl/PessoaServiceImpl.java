package com.desafiostefanini.service.impl;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.model.Pessoa;
import com.desafiostefanini.repository.PessoaRepository;
import com.desafiostefanini.repository.filter.PessoaFilter;
import com.desafiostefanini.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa salvar(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	@Override
	public Page<Pessoa> pesquisar(PessoaFilter pessoaFilter, Pageable pageable) {
		return this.pessoaRepository.filtrar(pessoaFilter, pageable);
	}

	@Override
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = this.buscarPorId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return this.pessoaRepository.save(pessoaSalva);
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findOne(id);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	@Override
	public void remover(Long id) {
		this.pessoaRepository.delete(id);
	}

	@Override
	public List<Endereco> buscarEnderecoPessoa(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findOne(id);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva.getEnderecos();
	}

}
