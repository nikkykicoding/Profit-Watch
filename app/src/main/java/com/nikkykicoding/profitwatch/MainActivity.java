package com.nikkykicoding.profitwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editStockName, editBuyPrice, editSellPrice, editQuantity;
    Button btnAddData, btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editStockName = findViewById(R.id.editText_stock_name);
        editBuyPrice = findViewById(R.id.editText_buy_price);
        editSellPrice = findViewById(R.id.editText_sell_price);
        editQuantity = findViewById(R.id.editText_quantity);
        btnAddData = findViewById(R.id.button_add);
        btnViewData = findViewById(R.id.button_view);

        addData();
        viewAll();
    }

    public void addData() {
        btnAddData.setOnClickListener(
                v -> {
                    boolean isInserted = myDb.insertData(
                            editStockName.getText().toString(),
                            Double.parseDouble(editBuyPrice.getText().toString()),
                            Double.parseDouble(editSellPrice.getText().toString()),
                            Integer.parseInt(editQuantity.getText().toString()),
                            "2024-09-12" // Add current date logic here
                    );
                    if (isInserted)
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
        );
    }

    public void viewAll() {
        btnViewData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, view_data.class);
            startActivity(intent);
        });
    }

}












//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}