package com.desafiostefanini.resource;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.dto.*;
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

	@ApiOperation(value = "Listagem e busca de pessoas segundo critérios.")
	@GetMapping
	public Page<PessoaDTO> pesquisar(PessoaFilter pessoaFilter, Pageable pageable) {
		return this.pessoaService.pesquisar(pessoaFilter, pageable);
	}

	@ApiOperation(value = "Informações detalhadas sobre uma pessoa específica.")
	@GetMapping(path = "/{id}", produces = "application/json")
	public PessoaDetelheDTO buscarPessoaPorId(@PathVariable Long id) {
		return this.pessoaService.buscarPorId(id);
	}

	@ApiOperation(value = "Cadastro de pessoa e seus endereços.")
	@PostMapping(produces = "application/json")
	public ResponseEntity<PessoaCadastroDTO> salvar(@Valid @RequestBody PessoaCadastroDTO pessoaCadastroDTO, HttpServletResponse response) {
		PessoaCadastroDTO pessoaCadastroDTOSalva = this.pessoaService.salvar(pessoaCadastroDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCadastroDTOSalva);
	}

	@ApiOperation(value = "Atualização de pessoa.")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<PessoaAtualizacaoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PessoaAtualizacaoDTO pessoaAtualizacaoDTO) {
		PessoaAtualizacaoDTO pessoaAtualizacaoDTOSalva = this.pessoaService.atualizar(id, pessoaAtualizacaoDTO);
		return ResponseEntity.ok(pessoaAtualizacaoDTOSalva);
	}

	@ApiOperation(value = "Remoção de pessoa e seus endereços.")
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.pessoaService.remover(id);
	}

	@ApiOperation(value = "Busca endereços da pessoa referenciada pelo identificador")
	@GetMapping(path = "/{id}/endereco", produces = "application/json")
	public PessoaEnderecoDTO buscarEnderecoPessoa(@PathVariable Long id) {
		return this.pessoaService.buscarPessoaEndereco(id);
	}

}
