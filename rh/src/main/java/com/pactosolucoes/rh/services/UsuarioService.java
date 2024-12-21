package com.pactosolucoes.rh.services;

import java.util.Optional;

import com.pactosolucoes.rh.domain.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	Optional<Usuario> obterPorId(Long id);
}
