package com.compassuol.compassuol.service;

import com.compassuol.compassuol.controller.dto.PagamentoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidacaoService {

    public boolean validarPagamento(PagamentoRequest pagamentoRequest) {
        if (pagamentoRequest.getValor() == null) {
            System.out.println("Erro: O valor é nulo.");
            return false;
        }

        if (pagamentoRequest.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Erro: O valor deve ser maior que zero. Valor recebido: " + pagamentoRequest.getValor());
            return false;
        }

        if (pagamentoRequest.getCodigo() == null || pagamentoRequest.getCodigo().isEmpty()) {
            System.out.println("Erro: O código é obrigatório.");
            return false;
        }

        System.out.println("Validação OK.");
        return true;
    }

}