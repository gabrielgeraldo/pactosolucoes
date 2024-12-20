package com.pactosolucoes.rh.services;

import java.util.List;
import java.util.Optional;

import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.domain.enums.StatusVaga;


public interface VagaService {

	Vaga salvar(Vaga vaga);
	
	Vaga atualizar(Vaga vaga);
	
	void deletar(Vaga lancamento);
	
	List<Vaga> buscar( Vaga vagaFiltro );
	
	void atualizarStatus(Vaga vaga, StatusVaga status);
	
	Optional<Vaga> obterPorId(String id);
	
}
