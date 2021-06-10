package org.demo.currency.api.services.impl;

import lombok.RequiredArgsConstructor;
import org.demo.currency.api.dtos.CurrencyDTO;
import org.demo.currency.api.services.ICurrencyService;
import org.demo.currency.domain.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CurrencyService implements ICurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public Mono<CurrencyDTO> calculateAmount(CurrencyDTO currencyDTO) {
        return currencyRepository.findByOriginCurrency(currencyDTO.getOriginCurrency())
                .last()
                .flatMap(currency -> Mono.just(CurrencyDTO.builder()
                        .originAmount(currencyDTO.getOriginAmount())
                        .originCurrency(currency.getOriginCurrency())
                        .destinationCurrency(currency.getDestinationCurrency())
                        .destinationAmount(currencyDTO.getOriginAmount().multiply(currency.getExchangeRate()))
                        .exchangeRate(currency.getExchangeRate())
                        .build()))
                .switchIfEmpty(Mono.empty());
    }
}
