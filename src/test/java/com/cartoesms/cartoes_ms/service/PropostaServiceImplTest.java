package com.cartoesms.cartoes_ms.service;

import com.cartoesms.cartoes_ms.domain.exception.ResourceNotFoundException;
import com.cartoesms.cartoes_ms.domain.model.Cliente;
import com.cartoesms.cartoes_ms.domain.model.Proposta;
import com.cartoesms.cartoes_ms.domain.model.enums.StatusProposta;
import com.cartoesms.cartoes_ms.domain.repository.PropostaRepository;
import com.cartoesms.cartoes_ms.domain.service.impl.PropostaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropostaServiceImplTest {
    @Mock
    private PropostaRepository propostaRepository;

    @InjectMocks
    private PropostaServiceImpl propostaService;

    private Proposta proposta;

    @BeforeEach
    void setUp() {
        proposta = new Proposta();
        proposta.setNomeProposta("Nome Proposta");
        proposta.setNumeroConta("123456");
        proposta.setLimite(1000.0);
        proposta.setCliente(new Cliente()); // Assuming Cliente has a default constructor
    }

    @Test
    void testLancarProposta() {
        when(propostaRepository.save(any())).thenReturn(proposta);

        Proposta result = propostaService.lancarProposta(proposta);

        assertEquals(false, result.getAtivo());
        assertEquals(StatusProposta.NEGADO.toString(), result.getStatus());
    }

    @Test
    void testAprovaProposta() {
        when(propostaRepository.findById(anyLong())).thenReturn(Optional.of(proposta));
        when(propostaRepository.save(any())).thenReturn(proposta);

        Proposta result = propostaService.aprovaProposta(1L);

        assertEquals(true, result.getAtivo());
        assertEquals(StatusProposta.APROVADO.toString(), result.getStatus());
    }

    @Test
    void testAprovaPropostaNotFoundException() {
        when(propostaRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> propostaService.aprovaProposta(1L));
    }

    @Test
    void testBuscarPropostaPorID() {
        when(propostaRepository.findById(anyLong())).thenReturn(Optional.of(proposta));

        Proposta result = propostaService.buscarPropostaPorID(1L);

        assertEquals(proposta, result);
    }
}
