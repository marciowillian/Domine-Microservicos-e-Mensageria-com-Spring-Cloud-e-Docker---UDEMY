package com.mwcc.mscartoes.domain.model.dto;

import com.mwcc.mscartoes.domain.model.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCartaoDTO {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static ClienteCartaoDTO fromModel(ClienteCartao clienteCartao){
        return new ClienteCartaoDTO(
                clienteCartao.getCartao().getNome(),
                clienteCartao.getCartao().getBandeira().toString(),
                clienteCartao.getLimite()
        );
    }
}
