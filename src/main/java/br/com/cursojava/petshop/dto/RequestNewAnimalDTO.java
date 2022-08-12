package br.com.cursojava.petshop.dto;

import br.com.cursojava.petshop.enums.Tipo;
import lombok.Getter;
import lombok.Setter;

//TODO trocar por padrão DTO
@Getter
@Setter
public class RequestNewAnimalDTO {
    private String nome;
    private String raca;
    private Tipo tipo;
    private Integer idade;
}
