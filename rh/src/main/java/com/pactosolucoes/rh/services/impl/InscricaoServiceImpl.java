package com.pactosolucoes.rh.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.pactosolucoes.rh.domain.Inscricao;
import com.pactosolucoes.rh.domain.Usuario;
import com.pactosolucoes.rh.domain.Vaga;
import com.pactosolucoes.rh.dtos.InscricaoDTO;
import com.pactosolucoes.rh.dtos.UsuarioDTO;
import com.pactosolucoes.rh.dtos.VagaDTO;
import com.pactosolucoes.rh.exception.UsuarioNotFoundException;
import com.pactosolucoes.rh.exception.VagaNotFoundException;
import com.pactosolucoes.rh.repositories.InscricaoRepository;
import com.pactosolucoes.rh.repositories.UsuarioRepository;
import com.pactosolucoes.rh.repositories.VagaRepository;
import com.pactosolucoes.rh.services.InscricaoService;

@Service
public class InscricaoServiceImpl implements InscricaoService {

	private final InscricaoRepository inscricaoRepository;

	private final UsuarioRepository usuarioRepository;

	private final VagaRepository vagaRepository;

	private final ModelMapper mapper;

	public InscricaoServiceImpl(InscricaoRepository inscricaoRepository, UsuarioRepository usuarioRepository,
			VagaRepository vagaRepository, ModelMapper mapper) {
		this.inscricaoRepository = inscricaoRepository;
		this.usuarioRepository = usuarioRepository;
		this.vagaRepository = vagaRepository;
		this.mapper = mapper;
	}

	@Override
	public InscricaoDTO inscrever(VagaDTO vagaDTO, UsuarioDTO usuarioDTO) {

		Vaga vaga = mapper.map(vagaDTO, Vaga.class);
		Usuario usuario = mapper.map(usuarioDTO, Usuario.class);

		Usuario usuarioRetorno = usuarioRepository.findById(usuario.getId()).orElseThrow(UsuarioNotFoundException::new);

		Vaga vagaRetorno = vagaRepository.findById(vaga.getId()).orElseThrow(VagaNotFoundException::new);

		Inscricao inscricao = new Inscricao(vagaRetorno,usuarioRetorno);
		
		Inscricao inscricaoRetorno = inscricaoRepository.save(inscricao);

		return mapper.map(inscricaoRetorno, InscricaoDTO.class);
	}

	@Override
	public InscricaoDTO atualizar(InscricaoDTO inscricaoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(InscricaoDTO inscricaoDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<InscricaoDTO> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<InscricaoDTO> obterPorId(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
