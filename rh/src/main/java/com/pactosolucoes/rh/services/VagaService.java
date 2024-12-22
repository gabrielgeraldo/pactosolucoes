package com.pactosolucoes.rh.services;

import java.util.List;
import java.util.Optional;

import com.pactosolucoes.rh.domain.enums.StatusVaga;
import com.pactosolucoes.rh.dtos.VagaDTO;


public interface VagaService {

	VagaDTO salvar(VagaDTO vagaDTO);
	
	VagaDTO atualizar(VagaDTO vagaDTO);
	
	void deletar(VagaDTO vagaDTO);
	
	List<VagaDTO> buscar(VagaDTO vagaFiltroDTO);
	
	void atualizarStatus(VagaDTO vagaDTO, StatusVaga status);
	
	Optional<VagaDTO> obterPorId(Long id);
	
}
