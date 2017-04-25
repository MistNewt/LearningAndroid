package com.example.sudhanshu.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;
    boolean whippedCream = false;
    boolean chocolate = false;
    String name = "";

    public void increaseQuantity(View view) {
        if (quantity < 100)
            quantity += 1;
        else
            quantity = 100;
        displayQuantity(quantity);
    }

    public void decreaseQuantity(View view) {
        if (quantity > 1)
            quantity -= 1;
        else quantity = 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        displayQuantity(quantity);
        int price = calculatePrice();
        String message = createOrderSummary(price);
        composeEmail(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the order on the screen.
     */
    /*
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/
    private void updateFields() {
        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.whip_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText editText = (EditText) findViewById(R.id.name_field);
        name = editText.getText().toString();
        whippedCream = whippedCheckBox.isChecked();
        chocolate = chocolateCheckBox.isChecked();
    }

    //Calculate price method
    private int calculatePrice() {
        int price = quantity * 5;
        updateFields();
        if (whippedCream)
            price += 1;
        if (chocolate)
            price += 2;
        return price;
    }

    // Create Order Summary method
    private String createOrderSummary(int price) {
        String message = getString(R.string.order_summary_name, name) + "\n";
        message = message + getString(R.string.addCream) + whippedCream + "\n";
        message = message + getString(R.string.addChocolate) + chocolate + "\n";
        message = message + getString(R.string.quantity) + ": " + quantity + "\n";
        message = message + getString(R.string.total) + ": $" + price + "\n" + getString(R.string.thankyou);
        return message;
    }

    //Email intent
    private void composeEmail(String order) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        String subject = getString(R.string.subject,name);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}