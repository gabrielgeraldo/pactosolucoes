package com.pactosolucoes.rh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pactosolucoes.rh.dtos.InscricaoDTO;
import com.pactosolucoes.rh.dtos.UsuarioDTO;
import com.pactosolucoes.rh.dtos.VagaDTO;
import com.pactosolucoes.rh.repositories.InscricaoRepository;
import com.pactosolucoes.rh.services.InscricaoService;

@Service
public class InscricaoServiceImpl implements InscricaoService {
	
	private InscricaoRepository repository;

	@Override
	public InscricaoDTO inscrever(VagaDTO vagaDTO, UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
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
