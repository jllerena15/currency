package org.demo.currency.api.services.impl;

import lombok.RequiredArgsConstructor;
import org.demo.currency.api.dtos.CurrencyDTO;
import org.demo.currency.api.mappers.CurrencyMapper;
import org.demo.currency.api.services.ICurrencyService;
import org.demo.currency.domain.entity.Currency;
import org.demo.currency.domain.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CurrencyService implements ICurrencyService {

    private final CurrencyRepository currencyRepository;

    private final CurrencyMapper currencyMapper;

    @Override
    public Mono<CurrencyDTO> calculateAmount(CurrencyDTO currencyDTO) {
        return currencyRepository.findByOriginCurrencyAndDestinationCurrency(currencyDTO.getOriginCurrency(), currencyDTO.getDestinationCurrency())
                .next()
                .flatMap(currency -> Mono.just(currencyMapper.toDTO(currencyDTO.getOriginAmount(), currency)))
                .switchIfEmpty(Mono.empty());
    }
}
