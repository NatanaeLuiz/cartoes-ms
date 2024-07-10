package com.cartoesms.cartoes_ms.application.controller;

import com.cartoesms.cartoes_ms.domain.model.Cliente;
import com.cartoesms.cartoes_ms.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
