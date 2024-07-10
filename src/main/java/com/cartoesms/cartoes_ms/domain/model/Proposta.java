package com.cartoesms.cartoes_ms.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProposta;
    private String numeroConta;
    private Double limite;
    private Boolean ativo;
    private String status;
    @ManyToOne
    private Cliente cliente;

    public Proposta(String nomeProposta, String numeroConta, Double limite, Cliente cliente) {
        this.nomeProposta = nomeProposta;
        this.numeroConta = numeroConta;
        this.limite = limite;
        this.cliente = cliente;
    }
}
