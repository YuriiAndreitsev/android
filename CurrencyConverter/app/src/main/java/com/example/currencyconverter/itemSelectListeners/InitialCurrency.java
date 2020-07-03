package com.example.currencyconverter.itemSelectListeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.currencyconverter.MainActivity;

public class InitialCurrency implements AdapterView.OnItemSelectedListener  {
    private String initialCurrency ="";

    public String getInitialCurrency() {
        return initialCurrency;
    }

    public void setInitialCurrency(String initialCurrency) {
        this.initialCurrency = initialCurrency;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        
         initialCurrency = parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(), initialCurrency.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
