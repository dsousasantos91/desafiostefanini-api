package com.desafiostefanini.service.impl;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.dto.EnderecoDTO;
import com.desafiostefanini.mapper.EnderecoMapper;
import com.desafiostefanini.repository.EnderecoRepository;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import com.desafiostefanini.service.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoMapper enderecoMapper;

	@Override
	public Page<EnderecoDTO> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable) {
		Page<Endereco> result = enderecoRepository.filtrar(enderecoFilter, pageable);
		return result.map(enderecoMapper::domainToDto);
	}

	@Override
	public EnderecoDTO atualizar(Long id, EnderecoDTO enderecoDTO) {
		Endereco enderecoSalvo = this.enderecoRepository.findOne(id);
		if (enderecoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(enderecoDTO, enderecoSalvo, "id");
		enderecoRepository.save(enderecoSalvo);
		return enderecoMapper.domainToDto(enderecoSalvo);
	}

	@Override
	public EnderecoDTO buscarPorId(Long id) {
		Endereco enderecoSalvo = this.enderecoRepository.findOne(id);
		if (enderecoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return enderecoMapper.domainToDto(enderecoSalvo);
	}

	@Override
	public void remover(Long id) {
		enderecoRepository.delete(id);
	}

	@Override
	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		EnderecoDTO enderecoDTOSalvo = buscarPorId(id);
		enderecoDTOSalvo.setAtivo(ativo);

		Endereco endereco = enderecoMapper.dtoToDomain(enderecoDTOSalvo);
		enderecoRepository.save(endereco);
	}
}
