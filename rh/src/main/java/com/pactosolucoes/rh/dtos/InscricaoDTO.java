package com.pactosolucoes.rh.dtos;

import com.pactosolucoes.rh.domain.Usuario;
import com.pactosolucoes.rh.domain.Vaga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoDTO {

	private Vaga vaga;

	private Usuario usuario;

}
