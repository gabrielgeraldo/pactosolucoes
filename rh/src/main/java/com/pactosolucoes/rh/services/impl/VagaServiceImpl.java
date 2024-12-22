package com.pactosolucoes.rh.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.domain.enums.StatusVaga;
import com.pactosolucoes.rh.dtos.VagaDTO;
import com.pactosolucoes.rh.repositories.VagaRepository;
import com.pactosolucoes.rh.services.VagaService;

@Service
public class VagaServiceImpl implements VagaService {

	private final VagaRepository repository;
	
	private final ModelMapper mapper;
	
	
	public VagaServiceImpl(VagaRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public VagaDTO salvar(VagaDTO vagaDTO) {
		
		Vaga vaga = mapper.map(vagaDTO, Vaga.class);
		
		vaga.setStatus(StatusVaga.ABERTA);
		Vaga vagaRetorno = repository.save(vaga);
		
		return mapper.map(vagaRetorno, VagaDTO.class); 
	}

	@Override
	public VagaDTO atualizar(VagaDTO vagaDTO) {
		
		Vaga vaga = mapper.map(vagaDTO, Vaga.class);
		
		Objects.requireNonNull(vaga.getId());
		Vaga vagaRetorno = repository.save(vaga);
		
		return mapper.map(vagaRetorno, VagaDTO.class);
		
	}

	@Override
	public void deletar(VagaDTO vagaDTO) {
		Vaga vaga = mapper.map(vagaDTO, Vaga.class);
		
		Objects.requireNonNull(vaga.getId());
		repository.delete(vaga);
	}

	@Override
	public List<VagaDTO> buscar(VagaDTO vagaFiltroDTO) {
		
		Vaga vagaFiltro = mapper.map(vagaFiltroDTO, Vaga.class);
		
		Example<Vaga> example = Example.of(vagaFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		
		List<Vaga> vagaRetorno = repository.findAll(example);
		
		return mapper.map(vagaRetorno, new TypeToken<List<VagaDTO>>() {}.getType());
	}

	@Override
	public void atualizarStatus(VagaDTO vagaDTO, StatusVaga status) {
		// vagaDTO.setStatus(status);
		atualizar(vagaDTO);
	}

	@Override
	public Optional<VagaDTO> obterPorId(Long id) {
		
		Optional<Vaga> vagaRetorno = repository.findById(id);
		
		VagaDTO vagaRetornoDTO = mapper.map(vagaRetorno.get(), VagaDTO.class);
		
		return Optional.of(vagaRetornoDTO);
	}

}
