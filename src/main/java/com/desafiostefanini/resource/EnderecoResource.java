package com.desafiostefanini.resource;

import com.desafiostefanini.domain.Endereco;
import com.desafiostefanini.repository.filter.EnderecoFilter;
import com.desafiostefanini.service.impl.EnderecoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(value = "API REST - Entidade Endereco")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

	@Autowired
	private EnderecoServiceImpl enderecoService;
	
	@ApiOperation(value = "Listagem e busca de endereços")
	@ApiImplicitParam
	@GetMapping(produces = "application/json")
	public Page<Endereco> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable) {
		return this.enderecoService.pesquisar(enderecoFilter, pageable);
	}

	@ApiOperation(value = "Busca de endereços pelo identificador")
	@GetMapping(path = "/{id}", produces = "application/json")
	public Endereco buscarPorId(@PathVariable Long id) {
		return this.enderecoService.buscarPorId(id);
	}

	@ApiOperation(value = "Cadastro de endereço")
	@PostMapping
	public ResponseEntity<Endereco> cadastrar(@Valid @RequestBody Endereco endereco, HttpServletResponse response) {
		Endereco enderecoSalvo = this.enderecoService.salvar(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
	}

	@ApiOperation(value = "Atualização de endereço")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
		Endereco enderecoSalvo = this.enderecoService.atualizar(id, endereco);
		return ResponseEntity.ok(enderecoSalvo);
	}

	@ApiOperation(value = "Remoção de endereço")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.enderecoService.remover(id);
	}

}
