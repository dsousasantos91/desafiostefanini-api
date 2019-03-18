package com.desafiostefanini.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.model.Pessoa;
import com.desafiostefanini.repository.PessoaRepository;
import com.desafiostefanini.repository.filter.PessoaFilter;
import com.desafiostefanini.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST - Entidade Pessoa")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;

	@ApiOperation(value = "Listagem e busca de pessoas e seus endereços.")
	@GetMapping
	public Page<Pessoa> pesquisar(PessoaFilter pessoaFilter, Pageable pageable) {
		return this.pessoaRepository.filtrar(pessoaFilter, pageable);
	}

	@ApiOperation(value = "Busca de pessoa e seus endereços pelo identificador da pessoa")
	@GetMapping(path = "/{pessoaId}", produces = "application/json")
	public Pessoa buscarPessoaPorId(@PathVariable Long pessoaId) {
		return this.pessoaService.buscarPorId(pessoaId);
	}

	@ApiOperation(value = "Cadastro de pessoa e seus endereços.")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = this.pessoaRepository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@ApiOperation(value = "Atualização de pessoa.")
	@PutMapping(path = "/{pessoaId}", produces = "application/json")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoaService.atualizar(pessoaId, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}

	@ApiOperation(value = "Remoção de pessoa e seus endereços.")
	@DeleteMapping(path = "/{pessoaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long pessoaId) {
		this.pessoaRepository.delete(pessoaId);
	}
	
	@ApiOperation(value = "Buscar endereços por pessoa")
	@ApiImplicitParam
	@GetMapping(path = "/{pessoaId}/endereco", produces = "application/json")
	public List<Endereco> buscarEnderecoPorPessoa(@PathVariable Long pessoaId, Pageable pageable) {
		return this.pessoaService.buscarEnderecoPorPessoa(pessoaId);
	}

}
