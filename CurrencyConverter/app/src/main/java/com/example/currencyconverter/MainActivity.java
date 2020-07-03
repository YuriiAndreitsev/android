package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconverter.itemSelectListeners.InitialCurrency;
import com.example.currencyconverter.itemSelectListeners.ResultCurrency;
import com.example.currencyconverter.service.CalculationService;

public class MainActivity extends AppCompatActivity {
    InitialCurrency initialCurrency = new InitialCurrency();
    ResultCurrency resultCurrency = new ResultCurrency();
    EditText amountOfMoney;
    CalculationService service = new CalculationService(initialCurrency,resultCurrency);
TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner initialCurrencySpinner = (Spinner) findViewById(R.id.initial_currency_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.initial_currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initialCurrencySpinner.setAdapter(adapter);
        initialCurrencySpinner.setOnItemSelectedListener(initialCurrency);

        Spinner resultCurrencySpinner = (Spinner) findViewById(R.id.result_currency_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.initial_currency, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultCurrencySpinner.setAdapter(adapter2);
        resultCurrencySpinner.setOnItemSelectedListener(resultCurrency);
    }

    public void calculateAction (View view){
        info = findViewById(R.id.info);

        amountOfMoney = findViewById(R.id.editTextNumber);
        if (!amountOfMoney.getText().toString().isEmpty()) {
            Double amount = Double.valueOf(amountOfMoney.getText().toString());
            if (!initialCurrency.getInitialCurrency().equals(resultCurrency.getResultCurrency()) && amount > 0.99) {
                double convertedResult = service.calculate(initialCurrency.getInitialCurrency(), resultCurrency.getResultCurrency(), amount);
                info.setText(String.valueOf(convertedResult));
                info.setTextColor(Color.GREEN);
                Toast.makeText(this, String.valueOf(convertedResult), Toast.LENGTH_SHORT).show();
            } else {
                error ();
            }
        } else {
            error ();
//                info.setTextColor(Color.RED);
//                info.setText("Choose different currencies \nor check a amount of money to convert");
            }
    }

    private void error (){
        info.setTextColor(Color.RED);
        info.setText("Choose different currencies \nor check a amount of money to convert");
    }
}