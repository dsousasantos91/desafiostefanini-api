package com.desafiostefanini.resource;

import com.desafiostefanini.dto.EnderecoDTO;
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

import javax.validation.Valid;

@Api(value = "API REST - Entidade Endereco")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

	@Autowired
	private EnderecoServiceImpl enderecoService;
	
	@ApiOperation(value = "Listagem e busca de endereços segundo critérios.")
	@ApiImplicitParam
	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<EnderecoDTO>> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable) {
		Page<EnderecoDTO> page = enderecoService.pesquisar(enderecoFilter, pageable);
		return ResponseEntity.ok(page);
	}

	@ApiOperation(value = "Busca de endereço pelo identificador")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id) {
		EnderecoDTO enderecoDTO = enderecoService.buscarPorId(id);
		return ResponseEntity.ok(enderecoDTO);
	}

	@ApiOperation(value = "Atualização de endereço")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO) {
		EnderecoDTO enderecoAtualizacaoDTOSalvo = enderecoService.atualizar(id, enderecoDTO);
		return ResponseEntity.ok(enderecoAtualizacaoDTOSalvo);
	}

	@ApiOperation(value = "Remoção de endereço")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		enderecoService.remover(id);
	}

	@ApiOperation(value = "Ativar ou inativar endereço")
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtiva(@PathVariable Long id, @RequestBody Boolean ativo) {
		enderecoService.atualizarPropriedadeAtivo(id, ativo);
	}
}
