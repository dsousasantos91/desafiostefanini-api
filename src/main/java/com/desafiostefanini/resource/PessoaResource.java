package com.desafiostefanini.resource;

import com.desafiostefanini.model.Endereco;
import com.desafiostefanini.model.Pessoa;
import com.desafiostefanini.repository.filter.PessoaFilter;
import com.desafiostefanini.service.impl.PessoaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Api(value = "API REST - Entidade Pessoa")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaServiceImpl pessoaService;

	@ApiOperation(value = "Listagem e busca de pessoas e seus endereços.")
	@GetMapping
	public Page<Pessoa> pesquisar(PessoaFilter pessoaFilter, Pageable pageable) {
		return this.pessoaService.pesquisar(pessoaFilter, pageable);
	}

	@ApiOperation(value = "Busca de pessoa e seus endereços pelo identificador da pessoa")
	@GetMapping(path = "/{id}", produces = "application/json")
	public Pessoa buscarPessoaPorId(@PathVariable Long id) {
		return this.pessoaService.buscarPorId(id);
	}

	@ApiOperation(value = "Cadastro de pessoa e seus endereços.")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = this.pessoaService.salvar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@ApiOperation(value = "Atualização de pessoa.")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoaService.atualizar(id, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}

	@ApiOperation(value = "Remoção de pessoa e seus endereços.")
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.pessoaService.remover(id);
	}

	@ApiOperation(value = "Busca endereços da pessoa referenciada pelo identificador")
	@GetMapping(path = "/{id}/enderecos", produces = "application/json")
	public List<Endereco> buscarEnderecoPessoa(@PathVariable Long id) {
		return this.pessoaService.buscarEnderecoPessoa(id);
	}

}
