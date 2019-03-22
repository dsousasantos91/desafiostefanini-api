package com.desafiostefanini.mapper;

import com.desafiostefanini.dto.*;
import com.desafiostefanini.domain.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PessoaMapper {

    Pessoa dtoToDomain(final PessoaDTO pessoaDTO);

    PessoaDTO domainToPessoaDto(final Pessoa pessoa);

    Pessoa dtoToDomain(final PessoaDetalheDTO pessoaDetalheDTO);

    PessoaDetalheDTO domainToPessoaDetalhesDto(final Pessoa pessoa);

    Pessoa dtoToDomain(final PessoaEnderecoDTO pessoaEnderecoDTO);

    PessoaEnderecoDTO domainToPessoaEnderecoDto(final Pessoa pessoa);

}
