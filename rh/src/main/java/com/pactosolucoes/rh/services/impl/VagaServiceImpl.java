package com.pactosolucoes.rh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.domain.enums.StatusVaga;
import com.pactosolucoes.rh.repositories.VagaRepository;
import com.pactosolucoes.rh.services.VagaService;

@Service
public class VagaServiceImpl implements VagaService{
	
	
	private VagaRepository repository;
	
	@Override
	@Transactional
	public Vaga salvar(Vaga vaga) {
		vaga.setStatus(StatusVaga.ABERTA);
		return repository.save(vaga);
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
