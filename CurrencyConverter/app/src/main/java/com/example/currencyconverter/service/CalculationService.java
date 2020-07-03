package com.example.currencyconverter.service;

import android.util.Log;
import android.widget.Toast;

import com.example.currencyconverter.MainActivity;
import com.example.currencyconverter.itemSelectListeners.InitialCurrency;
import com.example.currencyconverter.itemSelectListeners.ResultCurrency;

import java.util.Arrays;
import java.util.List;

public class CalculationService {

    InitialCurrency initialCurrency;
    ResultCurrency resultCurrency;

    private double usd = 27.1801;
    private double eur = 30.6592;
    private double gbp = 34.005;
    private double hrn = 1;

    public CalculationService(InitialCurrency initialCurrency, ResultCurrency resultCurrency) {
        this.initialCurrency = initialCurrency;
        this.resultCurrency = resultCurrency;
    }
    public double calculate(String initial, String result, double moneyToConvert) {

        double firstCurrency = 0;
        double secondCurrency = 0;
        List<String> list = Arrays.asList(initial,result);
        for (String  s :list   ) {
            double d = 0.0;
            switch (s){
                case "USD" : d = usd; break;
                case "EUR" : d = eur; break;
                case "GBP" : d = gbp; break;
                case "HRN" : d = hrn; break;
            }
            if (list.get(0).equals(s)){
                firstCurrency = d;
            } else {
                secondCurrency = d;
            }
        }
        return firstCurrency/secondCurrency*moneyToConvert;
    }
}
