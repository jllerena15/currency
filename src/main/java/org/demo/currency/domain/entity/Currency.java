package org.demo.currency.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {
    @Id
    private Long id;

    private String originCurrency;

    private String destinationCurrency;

    private BigDecimal exchangeRate;
}
