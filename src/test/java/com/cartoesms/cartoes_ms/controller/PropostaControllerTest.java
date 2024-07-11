package com.cartoesms.cartoes_ms.controller;

import com.cartoesms.cartoes_ms.application.controller.PropostaController;
import com.cartoesms.cartoes_ms.application.representation.PropostaRequest;
import com.cartoesms.cartoes_ms.domain.model.Cliente;
import com.cartoesms.cartoes_ms.domain.model.Proposta;
import com.cartoesms.cartoes_ms.domain.service.PropostaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropostaControllerTest {

    @Mock
    private PropostaService propostaService;

    @InjectMocks
    private PropostaController propostaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(propostaController).build();
    }

    @Test
    void testLancarProposta() {
        Cliente cliente = new Cliente(); // Supondo que Cliente tem um construtor padrão
        PropostaRequest propostaRequest = new PropostaRequest("Nome Proposta", "123456", 1000.0, cliente);
        Proposta proposta = new Proposta("Nome Proposta", "123456", 1000.0, cliente);

        when(propostaService.lancarProposta(any())).thenReturn(proposta);

        ResponseEntity<?> responseEntity = propostaController.lancarProposta(propostaRequest);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(proposta, responseEntity.getBody());
    }

    @Test
    void testAprovarProposta() {
        Long id = 1L;
        Proposta proposta = new Proposta("Nome Proposta", "123456", 1000.0, new Cliente());

        when(propostaService.aprovaProposta(anyLong())).thenReturn(proposta);

        ResponseEntity<Proposta> responseEntity = propostaController.aprovarProposta(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(proposta, responseEntity.getBody());
    }

    @Test
    void testBuscarPropostaPorID() {
        Long idProposta = 1L;
        Proposta proposta = new Proposta("Nome Proposta", "123456", 1000.0, new Cliente());

        when(propostaService.buscarPropostaPorID(anyLong())).thenReturn(proposta);

        ResponseEntity<?> responseEntity = propostaController.buscarPropostaPorID(idProposta);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(proposta, responseEntity.getBody());
    }

}
