package com.example.sudhanshu.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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

    public void increaseQuantity(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    public void decreaseQuantity(View view) {
        if (quantity > 0)
            quantity -= 1;
        else quantity = 0;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        displayQuantity(quantity);
        int price = calculatePrice();
        String message = createOrderSummary(price);
        displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    private void updateCheckBoxes() {
        CheckBox whippedCheckBox = (CheckBox)findViewById(R.id.whip_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        whippedCream = whippedCheckBox.isChecked();
        chocolate = chocolateCheckBox.isChecked();
    }

    //Calculate price method
    private int calculatePrice() {
        int price = quantity * 5;
        updateCheckBoxes();
        if (whippedCream)
            price += 2;
        if(chocolate)
            price += 3;
        return price;
    }

    // Create Order Summary method
    private String createOrderSummary(int price) {
        String message = "Name: Sudhanshu\n";
        message = message + "Add whipped cream? " + whippedCream + "\n";
        message = message + "Add chocolate? " + chocolate + "\n";
        message = message + "Quantity: " + quantity + "\n";
        message = message + "Total: $" + price + "\nThank you !";
        return message;
    }
}