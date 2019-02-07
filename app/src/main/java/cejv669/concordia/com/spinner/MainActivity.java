package cejv669.concordia.com.spinner;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner sp = findViewById(R.id.spinner_tip);
        final TextView tvResult = findViewById(R.id.lblResult);
        final EditText editPrice = findViewById(R.id.txtPrice);
        Button b = findViewById(R.id.btnCalculator);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.valueOf(editPrice.getText().toString());

                String spinnerValue = sp.getSelectedItem().toString();

                double tipAmount = 0.0;

                switch (spinnerValue)
                {
                    case "Large - 25%":
                        tipAmount = 0.25;
                        break;

                    case "Normal Service - 20%":
                        tipAmount = 0.2;
                        break;
                    case "Not that Great - 15%":
                        tipAmount = 0.15;
                        break;
                    case "Not Good - 10%":
                        tipAmount = 0.1;
                        break;
                }

                NumberFormat currency = NumberFormat.getCurrencyInstance();

                tvResult.setText(currency.format(amount * (1 + tipAmount)));

            }
        });




    }

}
