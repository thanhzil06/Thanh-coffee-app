package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.ActivityCart;
import com.example.helloworld.R;

public class Espresso extends AppCompatActivity {

    private Button btn_AddToCart_Espresso;
    private TextView txt_NumOfEspresso;
    private ImageView imgMinus, imgPlus;
    private int numberOrders = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso);

        initComponents();
        userChoice();
    }

    private void initComponents(){
        btn_AddToCart_Espresso = findViewById(R.id.button_AddToCart_Espresso);
        txt_NumOfEspresso = findViewById(R.id.numOfEspresso);
        imgMinus = findViewById(R.id.imgMinusEspresso);
        imgPlus = findViewById(R.id.imgPlusEspresso);
    }

    private void userChoice(){
        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrders>1){
                    numberOrders -=1;
                }
                txt_NumOfEspresso.setText(String.valueOf(numberOrders));
            }
        });

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrders +=1;
                txt_NumOfEspresso.setText(String.valueOf(numberOrders));
            }
        });

        btn_AddToCart_Espresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Added to customer's cart",
                        Toast.LENGTH_SHORT).show();
                addToCart();
            }
        });
    }

    private void addToCart(){
        ActivityCart.numEspresso += numberOrders;
    }
    private void addToCart_usingBundle(){
        Bundle bundle = new Bundle();
        // passing data into bundle
        bundle.putString("numOfEspresso",String.valueOf(numberOrders));
        Intent intent = new Intent(com.example.helloworld.Espresso.this, ActivityCart.class);
        // passing the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);
    }

}