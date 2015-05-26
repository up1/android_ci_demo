package workshop.temperatureconvertor;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText celsius_value;
    private EditText fahrenheit_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsius_value = (EditText) findViewById(R.id.celsius_value);
        fahrenheit_value = (EditText) findViewById(R.id.fahrenheit_value);

        celsius_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (fahrenheit_value.hasFocus() || !fahrenheit_value.hasWindowFocus() || s == null)
                    return;

                final String value = s.toString();
                if ("".equals(value)) {
                    fahrenheit_value.setText("");
                    return;
                }

                final double result = (9 / 5.0) * Double.parseDouble(value) + 32;
                fahrenheit_value.setText(String.valueOf(result));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fahrenheit_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (celsius_value.hasFocus() || !celsius_value.hasWindowFocus() || s == null)
                    return;

                final String value = s.toString();
                if ("".equals(value)) {
                    celsius_value.setText("");
                    return;
                }

                final double result = (Double.parseDouble(value) - 32) * (5 / 9.0);
                celsius_value.setText(String.valueOf(result));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
