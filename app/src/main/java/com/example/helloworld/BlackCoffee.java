package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BlackCoffee extends AppCompatActivity {

    private Button btn_AddToCart_BlackCf;
    private TextView txt_NumOfBlackCf;
    private ImageView imgMinus, imgPlus;
    private int numberOrders = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_coffee);

        initComponents();
        userChoice();
    }

    private void initComponents(){
        btn_AddToCart_BlackCf = findViewById(R.id.button_AddToCart_BlackCf);
        txt_NumOfBlackCf = findViewById(R.id.numOfBlackCf);
        imgMinus = findViewById(R.id.imgMinusBlackCf);
        imgPlus = findViewById(R.id.imgPlusBlackCf);
    }

    private void userChoice(){
        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(numberOrders>1){
                numberOrders -=1;
            }
            txt_NumOfBlackCf.setText(String.valueOf(numberOrders));
            }
        });

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrders +=1;
                txt_NumOfBlackCf.setText(String.valueOf(numberOrders));
            }
        });

        btn_AddToCart_BlackCf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Added to customer's cart",
                        Toast.LENGTH_SHORT).show();
                addToCart();
            }
        });
    }

    private void addToCart(){
        ActivityCart.numBlackCf += numberOrders;
    }
    private void addToCart_usingBundle(){
        Bundle bundle = new Bundle();
        // passing data into bundle
        bundle.putString("numOfBlackCf",String.valueOf(numberOrders));
        Intent intent = new Intent(BlackCoffee.this, ActivityCart.class);
        // passing the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);
    }
}