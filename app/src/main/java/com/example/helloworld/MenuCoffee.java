package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuCoffee extends AppCompatActivity {

    private Button btnBlackCoffee, btnEspresso;
    private TextView txtGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_coffee);

        initComponent();

        btnBlackCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_BlackCf();
            }
        });

        btnEspresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_Espresso();
            }
        });

        txtGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCart();
            }
        });
    }

    private void initComponent(){
        btnBlackCoffee = findViewById(R.id.buttonBlackCf);
        btnEspresso = findViewById(R.id.buttonEspresso);
        txtGoToCart = findViewById(R.id.text_goToCart);
    }

    private  void order_BlackCf(){
        Intent intent = new Intent(this, BlackCoffee.class);
        startActivity(intent);
    }
    private  void order_Espresso(){
        Intent intent = new Intent(this, Espresso.class);
        startActivity(intent);
    }
    private void goToCart(){
        Intent intent = new Intent(this, ActivityCart.class);
        startActivity(intent);
    }
}