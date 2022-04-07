package com.android.internal.alisontestapp.UserActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.internal.alisontestapp.Adapter.ProductRecyclerviewAdapter;
import com.android.internal.alisontestapp.Api.Api;
import com.android.internal.alisontestapp.Model.Products;
import com.android.internal.alisontestapp.R;
import com.android.internal.alisontestapp.Api.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ProductRecyclerviewAdapter adapter;
    private ArrayList<Products> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        getProducts();
    }

    private void getProducts() {
        Api retrofitInterface = RetrofitClient.getClient().create(Api.class);
        Call<List<Products>> call = retrofitInterface.getstatus();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                list = new ArrayList<>(response.body());
                adapter = new ProductRecyclerviewAdapter(list, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}