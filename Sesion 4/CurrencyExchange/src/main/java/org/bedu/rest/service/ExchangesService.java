package org.bedu.rest.service;

import org.bedu.rest.model.Currency;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ExchangesService {

    private Map<String, Currency> currencyExchanges;
    private Map<String, Double> mp;

    public ExchangesService(){
        currencyExchanges = new HashMap<String, Currency>();
        mp = new HashMap<>();
        mp.put("usd", 1.0);
        mp.put("eur", 2.0);
        currencyExchanges.put("mxn", new Currency("mxn", mp));
        mp = new HashMap<>();
        mp.put("mxn", 1.0);
        mp.put("eur", 2.0);
        currencyExchanges.put("usd", new Currency("usd", mp));
        mp = new HashMap<>();
        mp.put("usd", 1.0);
        mp.put("mxn", 2.0);
        currencyExchanges.put("eur", new Currency("eur", mp));

    }

    public boolean exists(String code){
        return currencyExchanges.containsKey(code.toLowerCase());
    }
    public List<Currency> getAll(){
        return new LinkedList<Currency>(currencyExchanges.values());
    }

    public Map<String, Double> getOne(String code){
        if(!exists(code)){
            throw new ContactNotFoundException(code);
        }

        return currencyExchanges.get(code.toLowerCase()).getExchanges();
    }

    public Map<String, Double> getOneToExch(String code, Double value){
        if(!exists(code)){
            throw new ContactNotFoundException(code);
        }

        Map<String, Double> currencies = currencyExchanges.get(code.toLowerCase()).getExchanges();

        Double val = 0.0;
        for ( String c: currencies.keySet()) {
            val = currencies.get(c) * value;
            currencies.put(c, val);
        }

        return currencies;
    }

}
