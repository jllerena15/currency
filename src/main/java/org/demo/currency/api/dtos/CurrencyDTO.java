package org.demo.currency.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyDTO {
    @NotNull
    @JsonProperty(value = "origin_amount")
    private BigDecimal originAmount;

    @NotNull
    @JsonProperty(value = "origin_currency")
    private String originCurrency;

    @NotNull
    @JsonProperty(value = "destination_currency")
    private String destinationCurrency;

    @JsonProperty(value = "destination_amount")
    private BigDecimal destinationAmount;

    @JsonProperty(value = "exchange_rate")
    private BigDecimal exchangeRate;
}
