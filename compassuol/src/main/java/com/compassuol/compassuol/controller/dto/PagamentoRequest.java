package com.compassuol.compassuol.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class PagamentoRequest {

    @JsonProperty("codigo")
    @NotBlank(message = "O código é obrigatório.")
    private String codigo;

    @JsonProperty("valor")
    @NotNull(message = "O valor não pode ser nulo.")
    @Positive(message = "O valor deve ser positivo.")
    private BigDecimal valor;

    @JsonProperty("descricao")
    private String descricao;

    public PagamentoRequest() {
    }

    public PagamentoRequest(String codigo, BigDecimal valor, String descricao) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "PagamentoRequest{" +
                "codigo='" + codigo + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
