package com.cartoesms.cartoes_ms.domain.service;

import com.cartoesms.cartoes_ms.domain.model.Proposta;
import org.springframework.stereotype.Service;

public interface PropostaService {

    public Proposta lancarProposta(Proposta proposta);

    public Proposta aprovaProposta(Long idProposta);

}
