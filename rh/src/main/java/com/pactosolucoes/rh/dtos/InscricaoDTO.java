package com.pactosolucoes.rh.dtos;

import com.pactosolucoes.rh.domain.Usuario;
import com.pactosolucoes.rh.domain.Vaga;

public record InscricaoDTO(Vaga vaga, Usuario usuario) {

}
