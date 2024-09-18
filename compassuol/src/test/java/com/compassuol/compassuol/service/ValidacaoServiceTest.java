package com.compassuol.compassuol.service;

import com.compassuol.compassuol.controller.dto.PagamentoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidacaoServiceTest {

    @Autowired
    private ValidacaoService validacaoService;

    @Test
    public void testValidarPagamentoValido() {
        PagamentoRequest request = new PagamentoRequest("vendedor123", new BigDecimal("100.00"), "Descrição de exemplo");
        boolean resultado = validacaoService.validarPagamento(request);
        assertTrue(resultado);
    }

    @Test
    public void testValidarPagamentoValorInvalido() {
        PagamentoRequest request = new PagamentoRequest("vendedor123", new BigDecimal("-100.00"), "Descrição de exemplo");
        boolean resultado = validacaoService.validarPagamento(request);
        assertFalse(resultado);
    }

    @Test
    public void testValidarPagamentoCodigoInvalido() {
        PagamentoRequest request = new PagamentoRequest(null, new BigDecimal("100.00"), "Descrição de exemplo");
        boolean resultado = validacaoService.validarPagamento(request);
        assertFalse(resultado);
    }
}
