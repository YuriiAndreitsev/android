package com.example.currencyconverter.itemSelectListeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class ResultCurrency implements AdapterView.OnItemSelectedListener  {
    private String resultCurrency ="";

    public String getResultCurrency() {
        return resultCurrency;
    }

    public void setResultCurrency(String resultCurrency) {
        this.resultCurrency = resultCurrency;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        resultCurrency  = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), resultCurrency.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
