package com.pactosolucoes.rh.domain;

import com.pactosolucoes.rh.dtos.CandidatoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="candidato")
@Table(name="candidato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id") 
public class Candidato {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    
    private String senha;
    
    public Candidato(CandidatoDTO candidatoRequest){
        this.email = candidatoRequest.email();
        this.senha = candidatoRequest.senha();
    }
	
}
