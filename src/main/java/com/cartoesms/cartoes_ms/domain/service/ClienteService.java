package com.cartoesms.cartoes_ms.domain.service;


import com.cartoesms.cartoes_ms.domain.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    public Cliente salvarCliente(Cliente cliente);

    public Optional<Cliente> buscarPorId(Long id);
}
