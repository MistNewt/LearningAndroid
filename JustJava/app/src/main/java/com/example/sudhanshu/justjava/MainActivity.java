package com.example.sudhanshu.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    void increaseQuantity(View view) {
        quantity += 1;
        display(quantity);
    }
    void decreaseQuantity(View view) {
        if(quantity > 0)
            quantity -= 1;
        else quantity = 0;
        display(quantity);
    }
    public void submitOrder(View view) {
        String message=NumberFormat.getCurrencyInstance().format(quantity*5);
        display(quantity);
        message = "Total: "+message+"\nThank you!";
        displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}