package com.carshiring.activities.home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.carshiring.R;
import com.carshiring.activities.mainsetup.LoginActivity;
import com.carshiring.adapters.CarResultsListAdapter;
import com.carshiring.fragments.SearchCarFragment;
import com.carshiring.models.SearchData;
import com.carshiring.models.UserDetails;
import com.carshiring.utilities.AppBaseActivity;
import com.carshiring.utilities.AppGlobal;
import com.carshiring.utilities.Utility;
import com.carshiring.webservices.ApiResponse;
import com.carshiring.webservices.RetroFitApis;
import com.carshiring.webservices.RetrofitApiBuilder;
import com.google.gson.Gson;
import com.mukesh.tinydb.TinyDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarsResultListActivity extends AppBaseActivity {
    Gson gson = new Gson();
    public String filter ;
    List<SearchData> listCarResult =  new ArrayList<>();
    List<SearchData.FeatureBean> featuresAllList =  new ArrayList<>();
    List<String>supplierList=new ArrayList<>();
    List<String>featuresList=new ArrayList<>();
    CarResultsListAdapter listAdapter;
    UserDetails userDetails = new UserDetails();
    TinyDB tinyDB;
    AppGlobal appGlobal=AppGlobal.getInstancess();
    Dialog dialog;
    RecyclerView recycler_search_cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_result_list);
        filter =  getResources().getString(R.string.recommended);
        actionBar = getSupportActionBar() ;
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back);
        }
        appGlobal.context=getApplicationContext();
        tinyDB = new TinyDB(getApplicationContext());
        dialog=new Dialog(this);
        listCarResult = SearchCarFragment.searchData;
//        get supplier

        for (SearchData searchData : listCarResult){
            supplierList.add(searchData.getSupplier());
        }
        Set<String> hs = new HashSet<>();
        hs.addAll(supplierList);
        supplierList.clear();
        supplierList.addAll(hs);

        recycler_search_cars = (RecyclerView) findViewById(R.id.recycler_search_cars);
        listAdapter = new CarResultsListAdapter(this,listCarResult, new CarResultsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SearchData carDetail) {
                if (tinyDB.contains("login_data")){
                    String data = tinyDB.getString("login_data");
                    userDetails = gson.fromJson(data,UserDetails.class);
                    if (userDetails.getUser_name()==null || userDetails.getUser_name().length()==0){
                        set = "update_profile";
                        setupoverlay(set);
                    } else {
                        Intent intent = new Intent(CarsResultListActivity.this,CarDetailActivity.class);
                        intent.putExtra("id_context",carDetail.getId_context());
                        intent.putExtra("type",carDetail.getType());
                        intent.putExtra("day",carDetail.getTime());
                        intent.putExtra("refer_type",carDetail.getRefer_type());
                        startActivity(intent);
                    }
                } else {
                    set = "login";
                    setupoverlay(set);
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        actionBar.setTitle(getResources().getString(R.string.car_results));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_search_cars.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycler_search_cars.addItemDecoration(itemDecoration);

        recycler_search_cars.setAdapter(listAdapter);
    }

    public void openSelectionSortedBy(View view) {
     /*   Intent intent = new Intent(CarsResultListActivity.this,SortingSelectionActivity.class);
        intent.putExtra("filter",filter) ;
        startActivityForResult(intent,200);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== 200){
            if(resultCode== RESULT_OK){
                filter = data.getStringExtra("filter");
                getShortedData() ;
            }
        }
        if(requestCode== 201){
            if(resultCode== RESULT_OK)
            {

            }
        }
    }

    private void getShortedData() {
        Collections.sort(listCarResult, new Comparator<SearchData>() {
            @Override
            public int compare(SearchData o1, SearchData o2) {
                int result = 0 ;
                switch(filter){
                    case "Recommended" :

                        break ;
                  /*  case "Price (Low to High)" :
                        result = (int)(Double.parseDouble(o1.getCar_list())-Double.parseDouble(o2.carmanagement_price)+1);
                        break ;

                    case "Price (High to Low)" :
                        result = (int)(Double.parseDouble(o2.carmanagement_price)-Double.parseDouble(o1.carmanagement_price));
                        break ;
*/
                    case "Rating" :

                        break ;
                }
                return result;
            }
        });
        listAdapter.notifyDataSetChanged();
    }

    public void openSelectionFilter(View view) {
        Intent intent = new Intent(CarsResultListActivity.this,SelectFilterActivity.class);
        startActivityForResult(intent,201);
    }
    String set ="";
    String fname,lname,email,phone,zip,license,licenseorigin,city,address,emaillogin,pass;

    private void setupoverlay(String set) {

        final EditText edtFname, edtLname, edtemail,edtPhone,edtZip, edtLicense,edtLicenseOrign,edtCity, edtAddress;
        Button btupdate;
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (set.equals("login")){
            dialog.setContentView(R.layout.popup_login);
            final EditText edtEmail= dialog.findViewById(R.id.et_email);
            final EditText edtPass= dialog.findViewById(R.id.et_password);
            final Button login= dialog.findViewById(R.id.bt_login);
            Button signup =(Button)dialog.findViewById(R.id.bt_signup);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    emaillogin =edtEmail.getText().toString().trim();
                    pass =edtPass.getText().toString().trim();

                    if (Utility.checkemail(emaillogin)){
                        if (!pass.isEmpty()){
                            login(emaillogin,pass);
                        } else {
                            Utility.message(getApplicationContext(),"Please enter your password");
                        }
                    } else {
                        Utility.message(getApplicationContext(),"Please enter valid email");
                    }
                }
            });


        } else if (set.equals("update_profile")){
            dialog.setContentView(R.layout.popup_updateprofile);
            edtFname = dialog.findViewById(R.id.etUserFirstName);
            edtLname = dialog.findViewById(R.id.etUserLastName);
            edtemail = dialog.findViewById(R.id.etUserEmail);
            edtPhone = dialog.findViewById(R.id.etUserPhoneNo);
            edtZip = dialog.findViewById(R.id.etUserzip);
            edtLicense = dialog.findViewById(R.id.etlicense);
            edtLicenseOrign = dialog.findViewById(R.id.etlicenseorigion);
            edtCity = dialog.findViewById(R.id.etcity);
            edtAddress = dialog.findViewById(R.id.etAddress);
            btupdate = dialog.findViewById(R.id.bt_update);
//            set onclick on update
            btupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fname = edtFname.getText().toString().trim();
                    lname = edtLname.getText().toString().trim();
                    email = edtemail.getText().toString().trim();
                    phone = edtPhone.getText().toString().trim();
                    zip = edtZip.getText().toString().trim();
                    license = edtLicense.getText().toString().trim();
                    licenseorigin = edtLicenseOrign.getText().toString().trim();
                    city = edtCity.getText().toString().trim();
                    address = edtAddress.getText().toString().trim();
                    dialog.dismiss();
                }
            });
        }


        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
    }

    private void login(String user, String pass) {
        if(!Utility.isNetworkConnected(getApplicationContext())){
            Toast.makeText(CarsResultListActivity.this, "No Network Connection!", Toast.LENGTH_SHORT).show();
            return;
        }
        Utility.showloadingPopup(this);
        RetroFitApis retroFitApis= RetrofitApiBuilder.getCargHiresapis();
        Call<ApiResponse> responseCall=retroFitApis.login(user,pass);
        responseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Utility.hidepopup();
                if(response.body().status==true)
                {
                    UserDetails userDetails = new UserDetails();
                    userDetails = response.body().response.userdetail;
                    String logindata=gson.toJson(userDetails);
                    appGlobal.setLoginData(logindata);
                    String st=  appGlobal.getUser_id();
                    dialog.dismiss();

                }
                else{
                    Utility.message(getApplicationContext(), response.body().msg);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Utility.hidepopup();
                Utility.message(getApplicationContext(),"Connection Error");
            }
        });
    }


}
