package com.desafiostefanini.resource;

import com.desafiostefanini.dto.EnderecoAtualizacaoDTO;
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

import javax.servlet.http.HttpServletResponse;
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
	public Page<EnderecoDTO> pesquisar(EnderecoFilter enderecoFilter, Pageable pageable) {
		return enderecoService.pesquisar(enderecoFilter, pageable);
	}

	@ApiOperation(value = "Busca de endereço pelo identificador")
	@GetMapping(path = "/{id}", produces = "application/json")
	public EnderecoDTO buscarPorId(@PathVariable Long id) {
		return enderecoService.buscarPorId(id);
	}

	@ApiOperation(value = "Atualização de endereço")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EnderecoAtualizacaoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EnderecoAtualizacaoDTO enderecoAtualizacaoDTO) {
		EnderecoAtualizacaoDTO enderecoAtualizacaoDTOSalvo = enderecoService.atualizar(id, enderecoAtualizacaoDTO);
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
