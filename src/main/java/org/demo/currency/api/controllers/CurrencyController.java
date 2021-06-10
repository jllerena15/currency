package org.demo.currency.api.controllers;

import lombok.RequiredArgsConstructor;
import org.demo.currency.api.dtos.CurrencyDTO;
import org.demo.currency.api.services.ICurrencyService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final ICurrencyService currencyService;

    @PostMapping("/calculate_amount")
    Mono<CurrencyDTO> calculateAmount(@RequestBody @Valid CurrencyDTO currencyDTO) {
        return currencyService.calculateAmount(currencyDTO);
    }
}
