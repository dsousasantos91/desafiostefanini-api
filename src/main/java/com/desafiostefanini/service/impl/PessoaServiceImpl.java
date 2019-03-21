package com.desafiostefanini.service.impl;

import com.desafiostefanini.domain.Pessoa;
import com.desafiostefanini.dto.PessoaCadastroDTO;
import com.desafiostefanini.dto.PessoaDTO;
import com.desafiostefanini.dto.PessoaDetelheDTO;
import com.desafiostefanini.dto.PessoaEnderecoDTO;
import com.desafiostefanini.mapper.PessoaMapper;
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

	@Autowired
    private PessoaMapper pessoaMapper;

	public PessoaCadastroDTO salvar(PessoaCadastroDTO pessoaCadastroDTO) {
		Pessoa pessoa = pessoaMapper.dtoToDomain(pessoaCadastroDTO);
		pessoaRepository.save(pessoa);
		return pessoaCadastroDTO;
	}

	@Override
	public Page<PessoaDTO> pesquisar(PessoaFilter pessoaFilter, Pageable pageable) {
		Page<Pessoa> result = pessoaRepository.filtrar(pessoaFilter, pageable);
		return result.map(pessoaMapper::domainToPessoaDto);
	}

	@Override
	public PessoaDTO atualizar(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoaSalva = pessoaRepository.findOne(id);
        if (pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(pessoaDTO, pessoaSalva, "id");
        pessoaRepository.save(pessoaSalva);
        return pessoaMapper.domainToPessoaDto(pessoaSalva);
    }

	@Override
	public PessoaDetelheDTO buscarPorId(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findOne(id);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaMapper.domainToPessoaDetalhesDto(pessoaSalva);
	}

	@Override
	public void remover(Long id) {
		pessoaRepository.delete(id);
	}

	@Override
	public PessoaEnderecoDTO buscarPessoaEndereco(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findOne(id);
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaMapper.domainToPessoaEnderecoDto(pessoaSalva);
	}

}
