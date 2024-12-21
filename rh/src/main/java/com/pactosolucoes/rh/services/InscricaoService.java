package com.pactosolucoes.rh.services;

import java.util.List;
import java.util.Optional;

import com.pactosolucoes.rh.domain.Inscricao;

public interface InscricaoService {

	Inscricao salvar(Inscricao inscricao);
	
	Inscricao atualizar(Inscricao inscricao);
	
	void deletar(Inscricao inscricao);
	
	List<Inscricao> buscar();
	
	Optional<Inscricao> obterPorId(String id);
	
}
