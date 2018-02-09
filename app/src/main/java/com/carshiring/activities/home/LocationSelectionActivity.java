package com.carshiring.activities.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.carshiring.R;
import com.carshiring.models.LocationAdapter;
import com.carshiring.utilities.AppBaseActivity;
import com.carshiring.utilities.Utility;
import com.carshiring.webservices.ApiResponse;
import com.carshiring.webservices.Data;
import com.carshiring.webservices.Location;
import com.carshiring.webservices.RetroFitApis;
import com.carshiring.webservices.RetrofitApiBuilder;
import com.mukesh.tinydb.TinyDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationSelectionActivity extends AppBaseActivity {
    public static final String RESPONSE_DATA = "location" ;
    public static final int RESPONSE_LOCATION = 200;
    LocationAdapter adapter ;
    RecyclerView rvLocations ;
    AutoCompleteTextView etSearchLocation;
    private String token,cityname, languagecode, keyword,TAG = LocationSelectionActivity.class.getName();
    List<Location> listLocations;

    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);

        tinyDB = new TinyDB(getApplicationContext());
        token  = tinyDB.getString("access_token") ;
        languagecode = tinyDB.getString("language_code");
//        setLanguages(languagecode);
        actionBar=getSupportActionBar();
        if(actionBar!=null) actionBar.hide();

        etSearchLocation  =  findViewById(R.id.etSearchLocation) ;
        etSearchLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                keyword  = charSequence.toString().trim() ;
                if (keyword.length()>2){
                    getLocationList(keyword,languagecode);
                }
//                refreshList(keyword,languagecode);
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        rvLocations = (RecyclerView) findViewById(R.id.rvLocations) ;
        listLocations =  new ArrayList<>();
        RecyclerView.LayoutManager layoutManager  =  new LinearLayoutManager(this);
        rvLocations.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rvLocations.addItemDecoration(itemDecoration);
        adapter = new LocationAdapter(listLocations, new LocationAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Location location) {
                Intent intent  =  new Intent();
                intent.putExtra(RESPONSE_DATA,location);
                setResult(RESPONSE_LOCATION,intent);
                finish();
            }
        });
        rvLocations.setAdapter(adapter);
//        getLocationList();
    }

/*    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
    public void setLanguages(String language_code){
        Locale locale = new Locale(language_code);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }*/

    public void getLocationList(String keyword, String languagecode) {

        final LocationSelectionActivity _this =  this ;
        Utility.showLoading(_this,"Finding Location List...");
        RetroFitApis retroFitApis =  RetrofitApiBuilder.getCarGatesapi() ;
        Call<ApiResponse> responseCall = retroFitApis.location_list(token,keyword,languagecode) ;
        responseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Utility.hidepopup();
                if(response.body()!=null){
                    Log.d(TAG, "onResponse: "+response.body().status);

                    if(response.body().status){
                        Data data  = response.body().response ;
                        if(data!=null){
                            listLocations.addAll(data.locations_list);
                            adapter.notifyDataSetChanged();
                        }
                    }else{
                        if(response.body().error_code==102)
                            getToken(_this);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Utility.hidepopup();
                Log.d(TAG, "onFailure: "+t.getMessage());
                Toast.makeText(LocationSelectionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void refreshList(String query) {
        final List<Location> filterList = new ArrayList<>();
        for (Location location:  listLocations) {
            if(location.city_name.trim().toLowerCase().contains(query.toLowerCase())){
                filterList.add(location);
            }
        }

        adapter = new LocationAdapter(filterList, new LocationAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Location location) {
                Intent intent  =  new Intent();
                intent.putExtra(RESPONSE_DATA,location);
                setResult(RESPONSE_LOCATION,intent);
                finish();
            }
        });
        rvLocations.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        actionBar.setTitle("Select Location");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void refreshTokenCallBack() {
        token = tinyDB.getString("access_token");
        getLocationList(keyword,languagecode);
    }
}
