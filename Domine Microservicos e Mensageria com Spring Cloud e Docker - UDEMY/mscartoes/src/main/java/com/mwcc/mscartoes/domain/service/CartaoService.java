package com.mwcc.mscartoes.domain.service;

import com.mwcc.mscartoes.domain.model.Cartao;
import com.mwcc.mscartoes.domain.repository.CartaoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CartaoService {
    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao save(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> findAll(){
        return cartaoRepository.findAll();
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long valor){
        var rendaBigDecimal = BigDecimal.valueOf(valor);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }

}
