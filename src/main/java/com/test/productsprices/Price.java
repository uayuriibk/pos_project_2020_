package com.test.productsprices;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {

    private BigDecimal value;
    private Currency currency;

    public Price(BigDecimal value, Currency currency){
        this.value = value;
        this.currency = currency;
    }

    public Price(BigDecimal value){
        this.value = value;
        currency = Currency.getInstance(Locale.US);
    }

    @Override
    public String toString(){
        return value + currency.getSymbol();
    }

}
