package com.desafiostefanini.mapper;

import com.desafiostefanini.dto.PessoaCadastroDTO;
import com.desafiostefanini.dto.PessoaDTO;
import com.desafiostefanini.domain.Pessoa;
import com.desafiostefanini.dto.PessoaDetelheDTO;
import com.desafiostefanini.dto.PessoaEnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PessoaMapper {

    Pessoa dtoToDomain(final PessoaDTO pessoaDTO);

    PessoaDTO domainToPessoaDto(final Pessoa pessoa);

    Pessoa dtoToDomain(final PessoaCadastroDTO pessoaCadastroDTO);

    PessoaCadastroDTO domainToPessoaCadastroDto(final Pessoa pessoa);

    Pessoa dtoToDomain(final PessoaDetelheDTO pessoaDetelheDTO);

    PessoaDetelheDTO domainToPessoaDetalhesDto(final Pessoa pessoa);

    Pessoa dtoToDomain(final PessoaEnderecoDTO pessoaEnderecoDTO);

    PessoaEnderecoDTO domainToPessoaEnderecoDto(final Pessoa pessoa);

}
