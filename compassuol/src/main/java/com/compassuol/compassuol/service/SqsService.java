package com.compassuol.compassuol.service;

import com.compassuol.compassuol.controller.dto.PagamentoDTO;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsService {

    private final SqsClient sqsClient;
    private final String queueUrl = "URL_DA_SUA_FILA_SQS";

    public SqsService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    public void enviarParaSqs(PagamentoDTO pagamentoDTO) {
        String mensagem = pagamentoDTO.toString();
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(mensagem)
                .build();

        sqsClient.sendMessage(sendMessageRequest);
        System.out.println("Mensagem enviada para a fila SQS: " + mensagem);
    }
}
