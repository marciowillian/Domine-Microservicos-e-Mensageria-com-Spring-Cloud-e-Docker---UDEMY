package com.mwcc.msavaliadorcredito.api.domain.service;

import com.mwcc.msavaliadorcredito.api.domain.model.CartaoCliente;
import com.mwcc.msavaliadorcredito.api.domain.model.DadosCliente;
import com.mwcc.msavaliadorcredito.api.domain.model.SituacaoClient;
import com.mwcc.msavaliadorcredito.infra.clients.CartoesResourceCliet;
import com.mwcc.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesResourceClient;
    private final CartoesResourceCliet cartoesResourceCliet;

    public SituacaoClient obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClienteResponse = clientesResourceClient.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResourceCliet.getCartoesPorCliente(cpf);

        return SituacaoClient.builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(cartoesResponse.getBody())
                .build();
    }
}
