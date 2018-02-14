package com.carshiring.activities.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.carshiring.R;
import com.carshiring.webservices.ApiResponse;
import com.carshiring.webservices.RetroFitApis;
import com.carshiring.webservices.RetrofitApiBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CarDetailActivity extends AppCompatActivity {
    String access_token="c9296133ffd83e0ebba5ccd9d489e0ea898e6fe5";
    String id_context="4";
    String type="1";
    String day="2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        setupApi();
    }
    private void setupApi() {
        RetroFitApis retroFitApis= RetrofitApiBuilder.getCarGatesapi();
        Call<ApiResponse> apiResponseCall=retroFitApis.car_detail(access_token,id_context,type,day);
        apiResponseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                String availability=response.body().response.car_detail.getStatus();
                Log.d("respsonse",availability);
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
