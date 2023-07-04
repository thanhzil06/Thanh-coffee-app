package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderPlace extends AppCompatActivity {

    private Button btnOrderTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_place);

        btnOrderTable = findViewById(R.id.buttonOrderTable);
        btnOrderTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openOrderTable(); }
        });
    }

    private void openOrderTable(){
        Intent intent = new Intent(this, MenuCoffee.class);
        startActivity(intent);
    }
}