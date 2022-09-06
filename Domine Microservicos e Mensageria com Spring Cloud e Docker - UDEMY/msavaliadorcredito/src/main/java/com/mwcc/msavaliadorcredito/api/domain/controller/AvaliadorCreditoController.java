package com.mwcc.msavaliadorcredito.api.domain.controller;

import com.mwcc.msavaliadorcredito.api.domain.model.SituacaoClient;
import com.mwcc.msavaliadorcredito.api.domain.service.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping(value = "/avaliacoes-credito")
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping("status")
    public String getStatus(){
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoClient> consultaSituacaoCliente(@RequestParam("cpf") String cpf){
        SituacaoClient situacaoClient = avaliadorCreditoService.obterSituacaoCliente(cpf);
        return ResponseEntity.ok(situacaoClient);
    }

}
