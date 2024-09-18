package com.compassuol.compassuol.controller;

import com.compassuol.compassuol.controller.dto.PagamentoDTO;
import com.compassuol.compassuol.controller.dto.PagamentoRequest;
import com.compassuol.compassuol.service.SqsService;
import com.compassuol.compassuol.service.ValidacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    private final ValidacaoService validacaoService;
    private final SqsService sqsService;

    public PagamentoController(ValidacaoService validacaoService, SqsService sqsService) {
        this.validacaoService = validacaoService;
        this.sqsService = sqsService;
    }

    @PostMapping("/enviar")
    public ResponseEntity<PagamentoDTO> processarPagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
        System.out.println("Recebido: " + pagamentoRequest);

        boolean validacao = validacaoService.validarPagamento(pagamentoRequest);
        System.out.println("Resultado da validação: " + validacao);

        if (!validacao) {
            return ResponseEntity.badRequest().body(null);
        }

        PagamentoDTO pagamentoDTO = new PagamentoDTO(
                pagamentoRequest.getCodigo(),
                pagamentoRequest.getValor(),
                pagamentoRequest.getDescricao()
        );

        sqsService.enviarParaSqs(pagamentoDTO);

        return ResponseEntity.ok(pagamentoDTO);
    }


}

