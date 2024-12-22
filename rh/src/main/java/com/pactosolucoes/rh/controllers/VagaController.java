package com.pactosolucoes.rh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pactosolucoes.rh.domain.enums.StatusVaga;
import com.pactosolucoes.rh.dtos.VagaDTO;
import com.pactosolucoes.rh.exception.RegraNegocioException;
import com.pactosolucoes.rh.services.VagaService;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

	@Autowired
	private VagaService vagaService;

	@GetMapping
	public ResponseEntity<List<VagaDTO>> buscar(
			@RequestParam(value ="titulo" , required = false) String titulo,
			@RequestParam(value = "descricao", required = false) String descricao
			) {
		
		VagaDTO vagaFiltroDTO = new VagaDTO(titulo, descricao);
		
		List<VagaDTO> vagasDTO = vagaService.buscar(vagaFiltroDTO);
		return ResponseEntity.ok(vagasDTO);
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody VagaDTO vagaDTO ) {
		try {
			vagaDTO = vagaService.salvar(vagaDTO);
			return new ResponseEntity(vagaDTO, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
