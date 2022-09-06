package com.mwcc.msclientes.domain.dto;

import com.mwcc.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveResource {

    private String cpf;
    private String nome;
    private int idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}
