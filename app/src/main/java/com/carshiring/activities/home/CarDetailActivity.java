package com.carshiring.activities.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.carshiring.R;
import com.carshiring.adapters.Page_Adapter;
import com.carshiring.fragments.CarDetailTab1Fragment;
import com.carshiring.fragments.CarDetailTab2Fragment;
import com.carshiring.fragments.CarDetailTab3Fragment;
import com.carshiring.models.CarDetailBean;
import com.carshiring.models.CoveragesBean;
import com.carshiring.models.ExtraBean;
import com.carshiring.utilities.Utility;
import com.carshiring.webservices.ApiResponse;
import com.carshiring.webservices.RetroFitApis;
import com.carshiring.webservices.RetrofitApiBuilder;
import com.google.gson.Gson;
import com.mukesh.tinydb.TinyDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CarDetailActivity extends AppCompatActivity {
    String token="fa6e9fcf829fbf3217d8e361421acf2c588903aa";
    String type="0";
    String refer_type="16";
    String day="2";
    String id_context="6226214527347845493110416";
    TabLayout tabLayout;
    Page_Adapter adapter;
    ActionBar actionBar;
    TinyDB sharpref;
    TinyDB tinyDB ;
    public static String logo,carPrice,carImage,modelname,currency,suppliername,suppliercity,termsurl
            ,fullprotectioncurrency,fullprotectionammount,driver_minage,driver_maxage;
    Gson gson = new Gson();
    public static ArrayList<ExtraBean> extralist=new ArrayList<>();
    public static List<CarDetailBean.FeatureBean> carSpecificationList=new ArrayList<>();
    public static List<CoveragesBean> coveragelist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        tinyDB = new TinyDB(getApplicationContext());
        /*token = tinyDB.getString("access_token");
        type = getIntent().getStringExtra("type");
        refer_type = getIntent().getStringExtra("refer_type");
        day = getIntent().getStringExtra("day");
        id_context = getIntent().getStringExtra("id_context");*/

//        call api

        setupApi();
    }

    private void setupApi() {
        Utility.showloadingPopup(this);
        RetroFitApis retroFitApis= RetrofitApiBuilder.getCarGatesapi();
        Call<ApiResponse> apiResponseCall=retroFitApis.car_detail(token,id_context,type,day,refer_type);
        apiResponseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

               if (response.body()!=null){
                   carImage=response.body().response.car_detail.image;
                   Log.d("respsonse",carImage);
                   logo=response.body().response.car_detail.supplier_logo;
                   Log.d("respsonse",logo);
                   modelname=response.body().response.car_detail.model;
                   carPrice=response.body().response.car_detail.price;
                   currency=response.body().response.car_detail.currency;
                   extralist= (ArrayList<ExtraBean>) response.body().response.car_detail.extra;
                   carSpecificationList= Arrays.asList(response.body().response.car_detail.feature);
                   suppliername=response.body().response.car_detail.supplier;
                   suppliercity=response.body().response.car_detail.supplier_city;
                   termsurl=response.body().response.car_detail.tc;
                   fullprotectioncurrency=response.body().response.car_detail.fullprotection_currency;
                   fullprotectionammount=response.body().response.car_detail.fullprotection_amount;
                   coveragelist=response.body().response.car_detail.coverages;
                   driver_minage=response.body().response.car_detail.driver_min_age;
                   driver_maxage=response.body().response.car_detail.driver_max_age;

                   Log.d("respsonse",""+carSpecificationList.size());
                   handletablayout();
               }

            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                Utility.hidepopup();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void handletablayout() {
        Utility.hidepopup();
        View view1=getLayoutInflater().inflate(R.layout.tabstyle,null);
        View view2=getLayoutInflater().inflate(R.layout.tabstyle,null);
        View view3=getLayoutInflater().inflate(R.layout.tabstyle,null);
        view1.findViewById(R.id.img_tab).setBackgroundResource(R.mipmap.ic_launcher);
        ImageView tab2= (ImageView) view2.findViewById(R.id.img_tab);
        Glide.with(getApplicationContext()).load(logo).into(tab2);
        view3.findViewById(R.id.img_tab).setBackgroundResource(R.drawable.ic_tab3);
        tabLayout= (TabLayout) findViewById(R.id.cardet_Tab);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view1));
        tabLayout.addTab(tabLayout.newTab().setCustomView(view2));
        tabLayout.addTab(tabLayout.newTab().setCustomView(view3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        CarDetailTab1Fragment tab1Fragment=new CarDetailTab1Fragment();
        CarDetailTab2Fragment tab2Fragment=new CarDetailTab2Fragment();
        CarDetailTab3Fragment tab3Fragment=new CarDetailTab3Fragment();
        final ViewPager pager= (ViewPager) findViewById(R.id.cardet_viewpager);
        adapter=new Page_Adapter(getSupportFragmentManager(),tabLayout.getTabCount(),tab1Fragment,tab2Fragment,tab3Fragment);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
