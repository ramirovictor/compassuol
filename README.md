# Desafio San Giorgio - Solução

Esta solução é a implementação do [Desafio San Giorgio](https://github.com/dtdtcamara/desafio-san-giorgio/blob/master/Desafio-San-Giorgio.md). 
O objetivo é criar uma API para receber requisições de pagamentos e processá-las, enviando os dados para uma fila SQS.
O projeto é desenvolvido em **Java** com **Spring Boot** e utiliza **AWS SQS** para o envio dos dados de pagamento. 

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **Controller**: Responsável por receber as requisições HTTP e processar os dados de pagamento.
- **Service**: Contém a lógica de validação e o envio dos dados para o serviço SQS.
- **DTO**: Representa os dados do pagamento que são validados e enviados.
- **Configuração AWS**: Configura a conexão com o serviço SQS da AWS.
- **Testes**: Utiliza JUnit e MockMvc para testar os endpoints e serviços.

## Funcionalidades

A API possui o seguinte endpoint:

### `POST /api/v1/pagamentos/enviar`

Recebe um objeto JSON contendo os detalhes de um pagamento e realiza as seguintes operações:

1. **Validação dos Dados**: Utiliza o Spring Validation para garantir que o valor do pagamento seja positivo e que o código do vendedor esteja presente.
2. **Processamento do Pagamento**: Valida o objeto recebido e, se os dados forem válidos, os envia para uma fila SQS configurada.
3. **Resposta**: Retorna uma resposta de sucesso (200 OK) se o pagamento for processado corretamente. Caso contrário, retorna um erro (400 Bad Request).

### Exemplo de Payload para o Endpoint:

```json
{
    "codigo": "vendedor123",
    "valor": 100.00,
    "descricao": "Pagamento de exemplo"
}
