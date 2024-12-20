package com.pactosolucoes.rh.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.domain.enums.StatusVaga;
import com.pactosolucoes.rh.repositories.VagaRepository;
import com.pactosolucoes.rh.services.VagaService;

@Service
public class VagaServiceImpl implements VagaService {

	private VagaRepository repository;

	@Override
	@Transactional
	public Vaga salvar(Vaga vaga) {
		vaga.setStatus(StatusVaga.ABERTA);
		return repository.save(vaga);
	}

	@Override
	public Vaga atualizar(Vaga vaga) {
		Objects.requireNonNull(vaga.getId());
		return repository.save(vaga);
	}

	@Override
	public void deletar(Vaga vaga) {
		Objects.requireNonNull(vaga.getId());
		repository.delete(vaga);
	}

	@Override
	public List<Vaga> buscar(Vaga vagaFiltro) {
		Example<Vaga> example = Example.of(vagaFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return repository.findAll(example);
	}

	@Override
	public void atualizarStatus(Vaga vaga, StatusVaga status) {
		vaga.setStatus(status);
		atualizar(vaga);
	}

	@Override
	public Optional<Vaga> obterPorId(String id) {
		return repository.findById(id);
	}

}
