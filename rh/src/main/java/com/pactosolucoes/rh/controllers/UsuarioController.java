package com.pactosolucoes.rh.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactosolucoes.rh.domain.Usuario;
import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.dtos.TokenDTO;
import com.pactosolucoes.rh.dtos.UsuarioDTO;
import com.pactosolucoes.rh.exception.ErroAutenticacao;
import com.pactosolucoes.rh.exception.RegraNegocioException;
import com.pactosolucoes.rh.services.JwtService;
import com.pactosolucoes.rh.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService service;
	
	private final JwtService jwtService;
	
	private final ModelMapper mapper;
	
	@PostMapping("/")
	public String helloword() {
		return "hello world";
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity<?> autenticar( @RequestBody UsuarioDTO dto ) {
		try {
			Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			String token = jwtService.gerarToken(usuarioAutenticado);
			TokenDTO tokenDTO = new TokenDTO( usuarioAutenticado.getNome(), token);
			return ResponseEntity.ok(tokenDTO);
		}catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody UsuarioDTO dto ) {
		
		Usuario usuario = mapper.map(dto, Usuario.class);
		
		try {
			Usuario usuarioSalvo = service.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
