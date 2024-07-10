package com.cartoesms.cartoes_ms.application.representation;

import com.cartoesms.cartoes_ms.domain.model.Cliente;
import com.cartoesms.cartoes_ms.domain.model.Proposta;
import jakarta.persistence.ManyToOne;

public record PropostaRequest(String nomeProposta, String numeroConta, Double limite, Cliente cliente){
    public Proposta toModel() {
        return new Proposta(nomeProposta, numeroConta, limite, cliente);
    }
}
