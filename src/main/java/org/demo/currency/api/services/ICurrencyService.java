package org.demo.currency.api.services;

import org.demo.currency.api.dtos.CurrencyDTO;
import reactor.core.publisher.Mono;

public interface ICurrencyService {
    Mono<CurrencyDTO> calculateAmount(CurrencyDTO currencyDTO);
}
