package com.mwcc.mscartoes.domain.model.dto;

import com.mwcc.mscartoes.domain.model.BandeiraCartao;
import com.mwcc.mscartoes.domain.model.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDTO {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao fromModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
