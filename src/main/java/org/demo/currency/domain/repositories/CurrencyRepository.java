package org.demo.currency.domain.repositories;

import org.demo.currency.domain.entity.Currency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CurrencyRepository extends ReactiveCrudRepository<Currency, Long> {
    Flux<Currency> findByOriginCurrency(String originCurrency);
}
