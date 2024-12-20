package com.pactosolucoes.rh.dtos;

import com.pactosolucoes.rh.domain.enums.StatusVaga;

public record VagaDTO(String titulo, String descricao, StatusVaga status) {

}
