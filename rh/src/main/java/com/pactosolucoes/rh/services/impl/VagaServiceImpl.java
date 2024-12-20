package com.pactosolucoes.rh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.domain.enums.StatusVaga;
import com.pactosolucoes.rh.services.VagaService;

@Service
public class VagaServiceImpl implements VagaService{

	@Override
	public Vaga salvar(Vaga vaga) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaga atualizar(Vaga vaga) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Vaga lancamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vaga> buscar(Vaga lancamentoFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarStatus(Vaga vaga, StatusVaga status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Vaga> obterPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
