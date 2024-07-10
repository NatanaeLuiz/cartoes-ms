package com.cartoesms.cartoes_ms.application.representation;

import com.cartoesms.cartoes_ms.domain.model.Cliente;
import com.cartoesms.cartoes_ms.domain.model.Proposta;

public record PropostaResponse(String nomeProposta, String numeroConta, Double limite, Boolean ativo, String status, Cliente cliente){

    public PropostaResponse toModel() {
        return new PropostaResponse(nomeProposta, numeroConta, limite, ativo, status, cliente);
    }
}
