package com.mwcc.mscartoes.domain.service;

import com.mwcc.mscartoes.domain.model.ClienteCartao;
import com.mwcc.mscartoes.domain.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listCartaoByCpf(String cpf){
        return clienteCartaoRepository.findByCpf(cpf);
    }
}
