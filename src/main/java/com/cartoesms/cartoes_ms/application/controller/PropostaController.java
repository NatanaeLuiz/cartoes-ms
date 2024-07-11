package com.cartoesms.cartoes_ms.application.controller;

import com.cartoesms.cartoes_ms.application.representation.PropostaRequest;
import com.cartoesms.cartoes_ms.domain.model.Proposta;
import com.cartoesms.cartoes_ms.domain.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<?> lancarProposta(@RequestBody PropostaRequest propostaRequest) {
        var propostaReq = propostaRequest.toModel();

        Proposta proposta = propostaService.lancarProposta(propostaReq);
        return new ResponseEntity<>(proposta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<Proposta> aprovarProposta(@PathVariable Long id) {
        Proposta propostaAprovada = propostaService.aprovaProposta(id);
        return new ResponseEntity<>(propostaAprovada, HttpStatus.OK);
    }

    @GetMapping("/buscar/{idProposta}")
    public ResponseEntity<?> buscarPropostaPorID(@PathVariable Long idProposta) {
        Proposta proposta = propostaService.buscarPropostaPorID(idProposta);
        return new ResponseEntity<>(proposta, HttpStatus.OK);
    }
}
