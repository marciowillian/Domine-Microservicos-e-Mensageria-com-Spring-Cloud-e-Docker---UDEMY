package com.mwcc.mscartoes.api;

import com.mwcc.mscartoes.domain.model.Cartao;
import com.mwcc.mscartoes.domain.model.ClienteCartao;
import com.mwcc.mscartoes.domain.model.dto.CartaoDTO;
import com.mwcc.mscartoes.domain.model.dto.ClienteCartaoDTO;
import com.mwcc.mscartoes.domain.service.CartaoService;
import com.mwcc.mscartoes.domain.service.ClienteCartaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController @AllArgsConstructor
@RequestMapping(value = "/cartoes")
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping(value = "/status")
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoDTO cartaoDTO){
        var cartao = cartaoDTO.fromModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(cartaoService.findAll());
    }

    @GetMapping("renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> cartoes = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok().body(cartoes);
    }

    @GetMapping("cpf")
    public ResponseEntity<List<ClienteCartaoDTO>> getCartoesPorCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> cartoesPorCliente = clienteCartaoService.listCartaoByCpf(cpf);
        List<ClienteCartaoDTO> result = cartoesPorCliente.stream().map(ClienteCartaoDTO::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
