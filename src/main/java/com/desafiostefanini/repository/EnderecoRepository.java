package com.desafiostefanini.repository;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.repository.query.EnderecoRespositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>, EnderecoRespositoryQuery {

}
