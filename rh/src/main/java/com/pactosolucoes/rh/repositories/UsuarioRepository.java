package com.pactosolucoes.rh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pactosolucoes.rh.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {  

	Optional<Usuario> findByEmail(String email);
	
}
