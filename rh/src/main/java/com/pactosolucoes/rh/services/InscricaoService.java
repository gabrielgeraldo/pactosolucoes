package com.pactosolucoes.rh.services;

import java.util.List;
import java.util.Optional;

import com.pactosolucoes.rh.dtos.InscricaoDTO;
import com.pactosolucoes.rh.dtos.UsuarioDTO;
import com.pactosolucoes.rh.dtos.VagaDTO;

public interface InscricaoService {

	InscricaoDTO inscrever(VagaDTO vagaDTO, UsuarioDTO usuarioDTO);
	
	InscricaoDTO atualizar(InscricaoDTO inscricaoDTO);
	
	void deletar(InscricaoDTO inscricaoDTO);
	
	List<InscricaoDTO> buscar();
	
	Optional<InscricaoDTO> obterPorId(String id);
	
}
