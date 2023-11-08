package com.example.fsmsystemvender.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fsmsystemvender.Model.OrderList;
import com.example.fsmsystemvender.R;
import com.example.fsmsystemvender.UI.MyOrderDetailsActivity;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder>
{

    private final ArrayList<OrderList> list;
    Context context;

    public OrderListAdapter(Context context, ArrayList<OrderList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OrderListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new OrderListAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlist_adapter,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.MyViewHolder holder, int position) {

        holder.tv_orderId.setText(""+list.get(position).getOrderID());
        holder.tv_shopId.setText(""+list.get(position).getShipname());
        holder.tv_order_status.setText("Pending");
        holder.tv_order_date.setText(""+list.get(position).getCreated_at());
        holder.tv_venderName.setText(""+list.get(position).getOrderFrom());
        holder.tv_orderPrice.setText(""+list.get(position).getFree());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MyOrderDetailsActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_orderId,tv_shopId,tv_order_status,tv_order_date,tv_venderName,tv_orderPrice;


        public MyViewHolder(View view) {
            super(view);
            tv_orderId = view.findViewById(R.id.tv_orderId);
            tv_shopId = view.findViewById(R.id.tv_shopId);
            tv_order_status = view.findViewById(R.id.tv_order_status);
            tv_order_date = view.findViewById(R.id.tv_order_date);
            tv_venderName = view.findViewById(R.id.tv_venderName);
            tv_orderPrice = view.findViewById(R.id.tv_orderPrice);

        }


    }
}
