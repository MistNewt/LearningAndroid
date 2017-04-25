package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        TextView textView = (TextView) findViewById(R.id.status_text_view);
        imageView.setImageResource(R.drawable.after_cookie);
        textView.setText("I'm so full");
    }

    public void eatAgain(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        TextView textView = (TextView) findViewById(R.id.status_text_view);
        imageView.setImageResource(R.drawable.before_cookie);
        textView.setText("I'm so hungry");
    }
}