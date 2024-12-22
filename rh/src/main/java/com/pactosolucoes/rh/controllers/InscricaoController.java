package com.pactosolucoes.rh.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pactosolucoes.rh.domain.Usuario;
import com.pactosolucoes.rh.dtos.InscricaoDTO;
import com.pactosolucoes.rh.dtos.UsuarioDTO;
import com.pactosolucoes.rh.dtos.VagaDTO;
import com.pactosolucoes.rh.exception.RegraNegocioException;
import com.pactosolucoes.rh.services.InscricaoService;
import com.pactosolucoes.rh.services.UsuarioService;
import com.pactosolucoes.rh.services.VagaService;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

	@Autowired
	private InscricaoService inscricaoService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity buscar(@RequestParam(value = "idvaga", required = false) Long idVaga,
			@RequestParam("idusuario") Long idUsuario) {

		InscricaoDTO inscricaoFiltroDTO = new InscricaoDTO();

		Optional<Usuario> usuario = usuarioService.obterPorId(idUsuario);
		if (!usuario.isPresent()) {
			return ResponseEntity.badRequest()
					.body("Não foi possível realizar a consulta. Usuário não encontrado para o Id informado.");
		} else {
			inscricaoFiltroDTO = new InscricaoDTO(null, usuario.get());
		}

		List<InscricaoDTO> inscricaoDTO = inscricaoService.buscar(inscricaoFiltroDTO);

		return ResponseEntity.ok(inscricaoDTO);
	}

	@PostMapping
	public ResponseEntity inscrever(@RequestBody InscricaoDTO inscricaoDTO) {
		try {
			inscricaoDTO = inscricaoService.inscrever(inscricaoDTO);
			return new ResponseEntity(inscricaoDTO, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
