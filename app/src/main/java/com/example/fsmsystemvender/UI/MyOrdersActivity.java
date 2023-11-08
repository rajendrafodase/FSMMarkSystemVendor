package com.example.fsmsystemvender.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fsmsystemvender.Adapter.OrderListAdapter;
import com.example.fsmsystemvender.Constant.TransparentProgressDialog;
import com.example.fsmsystemvender.Model.OrderList;
import com.example.fsmsystemvender.Model.Orders;
import com.example.fsmsystemvender.NetworkController.APIInterface;
import com.example.fsmsystemvender.NetworkController.MyConfig;
import com.example.fsmsystemvender.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrdersActivity extends AppCompatActivity {
    RecyclerView rel_orderList;
    TransparentProgressDialog pd;
    ArrayList<OrderList>orderLists=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("My Orders");
        rel_orderList = findViewById(R.id.rel_orderList);
        pd = new TransparentProgressDialog(MyOrdersActivity.this, R.drawable.progress);

        getOrders();
    }

    private void getOrders() {

        pd.show();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("CompanyCode", "RakeshApi2");
        requestBody.put("MargID", "230965");
        requestBody.put("SalesmanID", "001");
        requestBody.put("Type", "S");
        requestBody.put("Datetime", "");
        requestBody.put("index", "0");
        APIInterface apiInterface = MyConfig.getRetrofit().create(APIInterface.class);
        Call<ResponseBody> result = apiInterface.GetData(requestBody);

        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                pd.dismiss();
                String output= null;
                try {
                    output = response.body().string();
                    JSONObject jsonObject=new JSONObject(output);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        orderLists.add(new OrderList(jsonObject1));

                    }
                    rel_orderList.setLayoutManager(new LinearLayoutManager(MyOrdersActivity.this, RecyclerView.VERTICAL, false));
                    OrderListAdapter adaptertexi = new OrderListAdapter(MyOrdersActivity.this,orderLists);
                    rel_orderList.setAdapter(adaptertexi);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                pd.dismiss();

                //Log.d("Retrofit Error:",t.getMessage());
            }
        });
    }

/*


    private void getOrdersDecryption_resp(String output) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("data", output);
        requestBody.put("key", MyConfig.DemoKEY);


        APIInterface apiInterface = MyConfig.getDecryptionRetrofit().create(APIInterface.class);
        Call<ResponseBody> result = apiInterface.getresoponce(requestBody);

        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String output = null;
                try {
                    output = response.body().string();
                    Log.d("Data", "orderResponse-->" + output);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //Log.d("Retrofit Error:",t.getMessage());
            }
        });
    }

*/


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}