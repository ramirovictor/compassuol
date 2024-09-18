package com.compassuol.compassuol.controller;

import com.compassuol.compassuol.controller.dto.PagamentoRequest;
import com.compassuol.compassuol.service.SqsService;
import com.compassuol.compassuol.service.ValidacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PagamentoController.class)
public class PagamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SqsService sqsService;

    @MockBean
    private ValidacaoService validacaoService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void givenValidPagamentoRequest_whenEnviarPagamento_thenReturnsOk() throws Exception {
        PagamentoRequest pagamentoRequest = new PagamentoRequest("vendedor123", new BigDecimal("100.00"), "Descrição de exemplo");
        System.out.println("Valor no teste: " + pagamentoRequest.getValor());

        when(validacaoService.validarPagamento(any(PagamentoRequest.class))).thenReturn(true);

        mockMvc.perform(post("/api/v1/pagamentos/enviar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pagamentoRequest)))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
