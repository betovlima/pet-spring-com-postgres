package br.com.cursojava.petshop.dto;

import br.com.cursojava.petshop.enums.Tipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultListAnimalDTO {
    private String nome;
    private String raca;
    private Tipo tipo;
    private Integer idade;
}
