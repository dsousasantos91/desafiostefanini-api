package com.desafiostefanini.mapper;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EnderecoMapper {

    Endereco dtoToDomain(final EnderecoDTO enderecoDTO);

    EnderecoDTO domainToDto(final Endereco endereco);

}
