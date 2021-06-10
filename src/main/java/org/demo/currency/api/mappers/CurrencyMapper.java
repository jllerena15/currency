package org.demo.currency.api.mappers;

import org.demo.currency.api.dtos.CurrencyDTO;
import org.demo.currency.domain.entity.Currency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyMapper {
    public CurrencyDTO toDTO(BigDecimal originAmount, Currency currency) {
        return CurrencyDTO.builder()
                .originAmount(originAmount)
                .originCurrency(currency.getOriginCurrency())
                .destinationCurrency(currency.getDestinationCurrency())
                .destinationAmount(originAmount.multiply(currency.getExchangeRate()))
                .exchangeRate(currency.getExchangeRate())
                .build();
    }
}
