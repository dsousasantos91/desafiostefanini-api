package com.desafiostefanini.repository.impl;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import com.desafiostefanini.repository.query.EnderecoRespositoryQuery;
import com.desafiostefanini.utils.FormatarUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepositoryImpl implements EnderecoRespositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Endereco> filtrar(EnderecoFilter enderecoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Endereco> criteria = builder.createQuery(Endereco.class);
        Root<Endereco> root = criteria.from(Endereco.class);

        // criar as restrições
        Predicate[] predicates = criarRestricoes(enderecoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Endereco> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(enderecoFilter));
    }

    private Predicate[] criarRestricoes(EnderecoFilter enderecoFilter, CriteriaBuilder builder,
                                        Root<Endereco> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(enderecoFilter.getCep())) {
            predicates.add(builder.like(
                    builder.lower(root.get("cep")),"%" +
                            enderecoFilter.getCep().toLowerCase()
                                    .replace(".", "")
                                    .replace("-", "") + "%"));
        }

        if (!StringUtils.isEmpty(enderecoFilter.getCidade())) {
            predicates.add(builder.like(
                    builder.lower(root.get("cidade")),"%" +
                            FormatarUtils.removerAcentos(enderecoFilter.getCidade()).toLowerCase() + "%"));
        }

        if (enderecoFilter.getUf() != null) {
            predicates.add(builder.equal(
                    root.get("uf"), enderecoFilter.getUf()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Endereco> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(EnderecoFilter enderecoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Endereco> root = criteria.from(Endereco.class);

        Predicate[] predicates = criarRestricoes(enderecoFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }


}


