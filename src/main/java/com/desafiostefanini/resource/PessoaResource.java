package com.desafiostefanini.resource;

import com.desafiostefanini.domain.Pessoa;
import com.desafiostefanini.dto.*;
import com.desafiostefanini.event.RecursoCriadoEvent;
import com.desafiostefanini.mapper.PessoaMapper;
import com.desafiostefanini.repository.filter.PessoaFilter;
import com.desafiostefanini.service.impl.PessoaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(value = "API REST - Entidade Pessoa")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaServiceImpl pessoaService;

	@Autowired
	private PessoaMapper pessoaMapper;

	@Autowired
	private ApplicationEventPublisher publish;

	@ApiOperation(value = "Listagem e busca de pessoas segundo critérios.")
	@GetMapping
	public ResponseEntity<Page<PessoaDTO>> pesquisar(PessoaFilter pessoaFilter, Pageable pageable) {
		Page<PessoaDTO> page = pessoaService.pesquisar(pessoaFilter, pageable);
		return ResponseEntity.ok(page);
	}

	@ApiOperation(value = "Informações detalhadas sobre uma pessoa específica.")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<PessoaDetalheDTO> buscarPessoaPorId(@PathVariable Long id) {
		PessoaDetalheDTO pessoaDetalheDTO = pessoaService.buscarPorId(id);
		return ResponseEntity.ok(pessoaDetalheDTO);
	}

	@ApiOperation(value = "Cadastro de pessoa e seus endereços.")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = this.pessoaService.salvar(pessoa);
		publish.publishEvent(new RecursoCriadoEvent(this, response, pessoa.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@ApiOperation(value = "Atualização de pessoa.")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<PessoaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDTO) {
		PessoaDTO pessoaDTOSalva = this.pessoaService.atualizar(id, pessoaDTO);
		return ResponseEntity.ok(pessoaDTOSalva);
	}

	@ApiOperation(value = "Remoção de pessoa e seus endereços.")
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.pessoaService.remover(id);
	}

	@ApiOperation(value = "Busca endereços da pessoa referenciada pelo identificador")
	@GetMapping(path = "/{id}/endereco", produces = "application/json")
	public ResponseEntity<PessoaEnderecoDTO> buscarEnderecoPessoa(@PathVariable Long id) {
		PessoaEnderecoDTO pessoaEnderecoDTO = pessoaService.buscarPessoaEndereco(id);
		return ResponseEntity.ok(pessoaEnderecoDTO);
	}

}
