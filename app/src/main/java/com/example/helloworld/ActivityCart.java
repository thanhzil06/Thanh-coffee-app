package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class ActivityCart extends AppCompatActivity {

    // Unit price of every drink
    private final int unitPrice_BlackCf = 16;   // You can develop this variable by using bundle to get data from Black Coffee unit price
    private final int unitPrice_Espresso = 30;

   private TextView txt_order_BlackCf,
                    txt_order_Espresso,
                    txt_totalDrink, txt_tax, txt_totalBill;

   private EditText txt_customerMoney;
   private TextView txt_charge;
   private Button btnPay;

   static int   numBlackCf = 0,
                numEspresso = 0,
                totalDrink = 0;
   static long tax = 0, totalBill = 0, customerMoney, charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initComponents();
        writeBill();
        payment();
    }

    private void initComponents(){
        txt_order_BlackCf = findViewById(R.id.cart_BlackCf);
        txt_order_Espresso = findViewById(R.id.cart_Espresso);
        txt_totalDrink = findViewById(R.id.totalDrink);
        txt_tax = findViewById(R.id.tax);
        txt_totalBill = findViewById(R.id.totalBill);

        txt_customerMoney = findViewById(R.id.customerMoney);
        txt_charge = findViewById(R.id.charge);
        btnPay = findViewById(R.id.buttonPayment);
    }


    private void writeBill(){
        // Calculate total bill here...
        totalDrink = numBlackCf + numEspresso;
        totalBill = (numBlackCf*unitPrice_BlackCf + numEspresso*unitPrice_Espresso)*1000;
        tax = totalBill*5/100;
        totalBill +=tax;
        displayScreen();
    }
    private void displayScreen(){
        // Display cart on the screen
        txt_order_BlackCf.setText(String.valueOf(numBlackCf));
        txt_order_Espresso.setText(String.valueOf(numEspresso));
        txt_totalDrink.setText(String.valueOf(totalDrink));

        txt_tax.setText(convertIntToVNDCurrency(tax));
        txt_totalBill.setText(convertIntToVNDCurrency(totalBill));
        //txt_tax.setText(String.valueOf(tax));
        //txt_totalBill.setText(String.valueOf(totalBill));
    }

    private void writeBill_usingBundle(){
        // Calculate total bill here...
        Bundle bundle = getIntent().getExtras();
        txt_order_BlackCf.setText(bundle.getString("numOfBlackCf",bundle.toString()));

        numBlackCf = Integer.parseInt(txt_order_BlackCf.getText().toString());
        numEspresso = Integer.parseInt(txt_order_Espresso.getText().toString());

        totalDrink = numBlackCf + numEspresso;
        totalBill = (numBlackCf*unitPrice_BlackCf + numEspresso*unitPrice_Espresso)*1000;
        tax = totalBill*5/100;
        totalBill +=tax;

        // Display cart on the screen
        txt_totalDrink.setText(String.valueOf(totalDrink));
        txt_tax.setText(String.valueOf(tax));
        txt_totalBill.setText(String.valueOf(totalBill));

    }

    private void payment(){
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Customer's bill has been paid",
                        Toast.LENGTH_SHORT).show();

                customerMoney = Integer.parseInt(txt_customerMoney.getText().toString());
                charge = customerMoney - totalBill;
                txt_charge.setText(convertIntToVNDCurrency(charge));

                resetComponents();
            }
        });
    }
    private void resetComponents(){
        numBlackCf = 0;
        numEspresso = 0;
        totalDrink = 0;
        tax = 0;
        totalBill = 0;
        displayScreen();
    }

    private String convertIntToVNDCurrency(long val){
        long quotient, remainder;
        String[] currency = {"", ".","", " VND"};
        String str = "";

        quotient = val/1000;
        remainder = val%1000;
        currency[0] = String.valueOf(quotient);
        currency[2] = String.valueOf(remainder);
        for(String i:currency){
            str = str + i;
        }

        return str;
    }
}