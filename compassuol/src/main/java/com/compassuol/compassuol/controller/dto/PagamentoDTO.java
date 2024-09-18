package com.compassuol.compassuol.controller.dto;

import java.math.BigDecimal;

public class PagamentoDTO {
    private String codigo;
    private BigDecimal valor;
    private String descricao;

    public PagamentoDTO() {
    }

    public PagamentoDTO(String codigo, BigDecimal valor, String descricao) {
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
        return "PagamentoDTO{" +
                "codigo='" + codigo + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}


