package com.cartoesms.cartoes_ms.domain.service.impl;

import com.cartoesms.cartoes_ms.domain.exception.ResourceNotFoundException;
import com.cartoesms.cartoes_ms.domain.model.Proposta;
import com.cartoesms.cartoes_ms.domain.model.enums.StatusProposta;
import com.cartoesms.cartoes_ms.domain.repository.PropostaRepository;
import com.cartoesms.cartoes_ms.domain.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropostaServiceImpl implements PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Override
    public Proposta lancarProposta(Proposta proposta) {
        proposta.setAtivo(false);
        proposta.setStatus(StatusProposta.NEGADO.toString());
        return propostaRepository.save(proposta);
    }

    @Override
    public Proposta aprovaProposta(Long idProposta) {
        // Lógica para aprovar proposta
        Proposta proposta = propostaRepository.findById(idProposta)
                .orElseThrow(() -> new ResourceNotFoundException("Proposta não encontrada"));
        proposta.setAtivo(true);
        proposta.setStatus(StatusProposta.APROVADO.toString());
        return propostaRepository.save(proposta);
    }

    @Override
    public Proposta buscarPropostaPorID(Long idProposta) {
        Optional<Proposta> proposta = propostaRepository.findById(idProposta);
        return proposta.get();
    }


}
