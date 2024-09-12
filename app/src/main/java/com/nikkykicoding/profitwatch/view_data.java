package com.nikkykicoding.profitwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class view_data extends AppCompatActivity {

    DatabaseHelper myDb;
    RecyclerView recyclerView;
    StockAdapter stockAdapter;
    ArrayList<Stock> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        recyclerView = findViewById(R.id.recyclerView);
        myDb = new DatabaseHelper(this);

        stockList = new ArrayList<>();
        stockAdapter = new StockAdapter(stockList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(stockAdapter);

        loadStockData();
    }

    private void loadStockData() {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            return; // No data, just return
        }

        while (res.moveToNext()) {
            int id = res.getInt(0); // Get the ID
            String stockName = res.getString(1);
            double buyPrice = res.getDouble(2);
            double sellPrice = res.getDouble(3);
            int quantity = res.getInt(4);
            String date = res.getString(5);
            double profit = (sellPrice - buyPrice) * quantity;

            Stock stock = new Stock(id, stockName, buyPrice, sellPrice, date, profit); // Pass the ID to Stock object
            stockList.add(stock);
        }


        stockAdapter.notifyDataSetChanged();
    }
}
