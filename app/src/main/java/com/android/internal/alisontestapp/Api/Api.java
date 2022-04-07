package com.android.internal.alisontestapp.Api;

import com.android.internal.alisontestapp.Model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("products")
    Call<List<Products>> getstatus();
}
