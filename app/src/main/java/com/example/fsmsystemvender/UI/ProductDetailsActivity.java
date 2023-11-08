package com.example.fsmsystemvender.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fsmsystemvender.MainActivity;
import com.example.fsmsystemvender.R;

public class ProductDetailsActivity extends AppCompatActivity {
    LinearLayout linear_bottom_cart;
    String ProName = "", proMrp = "", proStock = "", prorate = "", prodiscount = "", proCompany = "", proremark = "";
    TextView tvProductName,tv_CurrentPrice,tv_main_price,tv_perc_off,tv_brand,tv_decription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Product Details");
        Intent intent = getIntent();
        ProName = intent.getStringExtra("ProName");
        proMrp = intent.getStringExtra("proMrp");
        proStock = intent.getStringExtra("proStock");
        prorate = intent.getStringExtra("prorate");
        prodiscount = intent.getStringExtra("prodiscount");
        proCompany = intent.getStringExtra("proCompany");
        proremark = intent.getStringExtra("proremark");

        tvProductName = findViewById(R.id.tvProductName);
        tv_CurrentPrice = findViewById(R.id.tv_CurrentPrice);
        tv_CurrentPrice.setPaintFlags( tv_CurrentPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        tv_main_price = findViewById(R.id.tv_main_price);
        tv_perc_off = findViewById(R.id.tv_perc_off);
        tv_brand = findViewById(R.id.tv_brand);
        tv_decription = findViewById(R.id.tv_decription);

        tvProductName.setText(ProName);
        tv_CurrentPrice.setText("M.R.P:"+proMrp);
        tv_main_price.setText("M.R.P:"+prorate);
        tv_perc_off.setText(prodiscount+" %off");
        tv_brand.setText("Stock:"+proStock);
        tv_decription.setText(proremark);

        linear_bottom_cart = findViewById(R.id.linear_bottom_cart);
        linear_bottom_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this, CartPageActivity.class));

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}