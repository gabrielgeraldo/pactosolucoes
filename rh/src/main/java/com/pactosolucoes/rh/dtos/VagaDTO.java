package com.pactosolucoes.rh.dtos;

import com.pactosolucoes.rh.domain.enums.StatusVaga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO {
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
}
