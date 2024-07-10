package com.cartoesms.cartoes_ms.domain.service.impl;

import com.cartoesms.cartoes_ms.domain.model.Cliente;
import com.cartoesms.cartoes_ms.domain.repository.ClienteRepository;
import com.cartoesms.cartoes_ms.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
}
