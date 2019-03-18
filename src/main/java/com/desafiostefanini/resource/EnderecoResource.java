package com.desafiostefanini.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.desafiostefanini.repository.EnderecoRepository;
import com.desafiostefanini.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST - Entidade Endereco")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoService;
	
	@ApiOperation(value = "Listagem e busca de endereços")
	@ApiImplicitParam
	@GetMapping(produces = "application/json")
	public List<Endereco> listar() {
		return this.enderecoRepository.findAll();
	}

	@ApiOperation(value = "Busca de endereços pelo identificador")
	@GetMapping(path = "/{enderecoId}", produces = "application/json")
	public Endereco buscarPorId(@PathVariable Long enderecoId) {
		return this.enderecoRepository.findOne(enderecoId);
	}

	@ApiOperation(value = "Cadastro de endereço")
	@PostMapping
	public ResponseEntity<Endereco> cadastrar(@Valid @RequestBody Endereco endereco, HttpServletResponse response) {
		Endereco enderecoSalvo = this.enderecoRepository.save(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
	}

	@ApiOperation(value = "Atualização de endereço")
	@PutMapping(path = "/{enderecoId}", produces = "application/json")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long enderecoId, @Valid @RequestBody Endereco endereco) {
		Endereco enderecoSalvo = this.enderecoService.atualizar(enderecoId, endereco);
		return ResponseEntity.ok(enderecoSalvo);
	}

	@ApiOperation(value = "Remoção de endereço")
	@DeleteMapping("/{enderecoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long enderecoId) {
		this.enderecoRepository.delete(enderecoId);
	}

}
