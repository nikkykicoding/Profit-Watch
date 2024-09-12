package com.nikkykicoding.profitwatch;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder> {

    private ArrayList<Stock> stockList;

    public StockAdapter(ArrayList<Stock> stockList) {
        this.stockList = stockList;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_item, parent, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        Stock stock = stockList.get(position);

        holder.txtStockName.setText(stock.getStockName());
        holder.txtBuyPrice.setText(String.valueOf(stock.getBuyPrice()));
        holder.txtSellPrice.setText(String.valueOf(stock.getSellPrice()));
        holder.txtDate.setText(stock.getDate());
        holder.txtProfit.setText(String.valueOf(stock.getProfit()));

        // Set onClickListener for the delete button
        holder.btnDelete.setOnClickListener(v -> {
            DatabaseHelper dbHelper = new DatabaseHelper(v.getContext());
            dbHelper.deleteData(String.valueOf(stockList.get(position).getId())); // Assuming Stock model has a getId() method
            stockList.remove(position); // Remove from the list
            notifyItemRemoved(position); // Notify RecyclerView to update
            notifyItemRangeChanged(position, stockList.size());
        });
    }


    @Override
    public int getItemCount() {
        return stockList.size();
    }

    public static class StockViewHolder extends RecyclerView.ViewHolder {

        TextView txtStockName, txtBuyPrice, txtSellPrice, txtDate, txtProfit;
        Button btnDelete;

        public StockViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStockName = itemView.findViewById(R.id.txtStockName);
            txtBuyPrice = itemView.findViewById(R.id.txtBuyPrice);
            txtSellPrice = itemView.findViewById(R.id.txtSellPrice);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtProfit = itemView.findViewById(R.id.txtProfit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }




}
