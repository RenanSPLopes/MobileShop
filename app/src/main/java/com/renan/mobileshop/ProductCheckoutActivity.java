package com.renan.mobileshop;
import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.widget.Button;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductCheckoutActivity extends Activity {

    private final String RegexPattern = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_checkout);

        Button confirmButton = findViewById(R.id.confirm_order_button);
        confirmButton.setOnClickListener(v -> confirmOrder());
    }

    private void confirmOrder(){

        if(isValid()){
            Intent intent = new Intent(this, PaymentFinalizedActivity.class);
            startActivity(intent);
        }
    }

    public boolean isValid(){

        boolean valid = true;
        TextInputLayout cardNumberInputLayout = findViewById(R.id.cardNumber_input);
        cardNumberInputLayout.setError(null);
        TextInputEditText cardText = findViewById(R.id.cardNumber_editText);
        String cardNumber = cardText.getText().toString();

        TextInputLayout expirationDateInputLayout = findViewById(R.id.expirationDate_input);
        expirationDateInputLayout.setError(null);
        TextInputEditText expirationDateText = findViewById(R.id.expirationDate_editText);
        String expirationDate = expirationDateText.getText().toString();

        TextInputLayout securityNumberInputLayout = findViewById(R.id.securityNumber_input);
        securityNumberInputLayout.setError(null);
        TextInputEditText securityNumberText = findViewById(R.id.securityNumber_editText);
        String securityNumber = securityNumberText.getText().toString();


        if(!isValidCardNumber(cardNumber)){
            cardNumberInputLayout.setErrorEnabled(true);
            cardNumberInputLayout.setError("Número de cartão inválido.");
            valid = false;
        }

        if(!isValidExpirationDate(expirationDate)){
            expirationDateInputLayout.setErrorEnabled(true);
            expirationDateInputLayout.setError("Data de expiração inválida.");
            valid = false;
        }

        if(securityNumber.isEmpty()){
            securityNumberInputLayout.setErrorEnabled(true);
            securityNumberInputLayout.setError("O código de segurança é obrigatório.");
            valid = false;
        }

        return valid;
    }

    private boolean isValidCardNumber(String number){
        return number.matches(RegexPattern);
    }

    private boolean isValidExpirationDate(String expirationDate) {
        DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

        try{
            Date expiryDate = dateFormat.parse(expirationDate);
            Date currentDate = new Date();

            return currentDate.before(expiryDate);

        } catch (ParseException ex){
            return false;
        }

    }
}
