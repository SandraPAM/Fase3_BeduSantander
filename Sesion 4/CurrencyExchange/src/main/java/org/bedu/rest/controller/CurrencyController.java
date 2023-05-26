package org.bedu.rest.controller;

import org.bedu.rest.model.Currency;
import org.bedu.rest.service.ExchangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("currencies")
@Validated
public class CurrencyController {

    private ExchangesService exchangesService;

    @Autowired
    public CurrencyController(ExchangesService exchangesService){
        this.exchangesService = exchangesService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getCurrencyAll(){
        return exchangesService.getAll();
    }

    @GetMapping("{code}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> getCurrencyExchanges(@PathVariable("code") String code){
        return exchangesService.getOne(code);
    }

    @GetMapping("{code}/exchanges/{value}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> getCurrencyExchangesValue(@PathVariable("code") String code,
                                                         @PathVariable("value") Double value){
        return exchangesService.getOneToExch(code,value);
    }
}
