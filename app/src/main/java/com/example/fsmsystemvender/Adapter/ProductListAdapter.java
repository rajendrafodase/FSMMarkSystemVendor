package com.example.fsmsystemvender.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fsmsystemvender.Model.OrderList;
import com.example.fsmsystemvender.Model.ProductList;
import com.example.fsmsystemvender.R;
import com.example.fsmsystemvender.UI.MyOrderDetailsActivity;
import com.example.fsmsystemvender.UI.ProductDetailsActivity;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private final ArrayList<ProductList> list;
    Context context;
    int qty=0;

    public ProductListAdapter(Context context, ArrayList<ProductList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ProductListAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_adapter, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.MyViewHolder holder, int position) {


        holder.tv_proname.setText("" + list.get(position).getName());
        holder.tv_stock.setText("Available Stock:" + list.get(position).getStock());
        holder.tv_Mainmrp.setText("M.R.P:" + list.get(position).getRate());
        holder.tv_mrp.setText(String.valueOf(list.get(position).getmRP()));
        holder.tv_mrp.setPaintFlags(holder.tv_mrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        holder.tv_off.setText("0% OFF");

        holder.iv_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProductDetailsActivity.class);
                i.putExtra("ProName", list.get(position).getName());
                i.putExtra("proMrp", list.get(position).getmRP());
                i.putExtra("proStock", list.get(position).getStock());
                i.putExtra("prorate", list.get(position).getRate());
                i.putExtra("prodiscount", list.get(position).getFree());
                i.putExtra("proCompany", list.get(position).getCompany());
                i.putExtra("proremark", list.get(position).getRemarks());
                context.startActivity(i);
            }
        });

        holder.tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tv_add.setVisibility(View.GONE);
                holder.linear_first.setVisibility(View.VISIBLE);
                qty=1;
                holder.pro_cust_quantity.setText(String.valueOf(qty));
            }
        });
        holder.iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty--;
                holder.pro_cust_quantity.setText(String.valueOf(qty));
            }
        });
        holder.iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty++;
                holder.pro_cust_quantity.setText(String.valueOf(qty));

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_proname, tv_stock, tv_Mainmrp, tv_mrp, tv_off, tv_add, pro_cust_quantity;
        LinearLayout linear_first;
        ImageView iv_ImageView, iv_minus, iv_plus;


        public MyViewHolder(View view) {
            super(view);
            iv_ImageView = view.findViewById(R.id.iv_ImageView);
            tv_proname = view.findViewById(R.id.tv_proname);
            tv_stock = view.findViewById(R.id.tv_stock);
            tv_Mainmrp = view.findViewById(R.id.tv_Mainmrp);
            tv_mrp = view.findViewById(R.id.tv_mrp);
            tv_off = view.findViewById(R.id.tv_off);
            tv_add = view.findViewById(R.id.tv_add);
            linear_first = view.findViewById(R.id.linear_first);
            pro_cust_quantity = view.findViewById(R.id.pro_cust_quantity);
            iv_minus = view.findViewById(R.id.iv_minus);
            iv_plus = view.findViewById(R.id.iv_plus);

        }


    }
}
