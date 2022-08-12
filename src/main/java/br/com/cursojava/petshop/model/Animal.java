package br.com.cursojava.petshop.model;

import br.com.cursojava.petshop.enums.Tipo;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String raca;
    //TODO trocar por uma descrição mais simples para entendimento
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private Integer idade;
}
