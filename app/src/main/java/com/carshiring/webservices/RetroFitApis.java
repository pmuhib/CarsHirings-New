package com.carshiring.webservices;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Muhib.
 * Contact Number : +91 9796173066
 */
public interface RetroFitApis {
    @FormUrlEncoded
    @POST("token")
    Call<ApiResponse> token(@Field("grant_type") String grant_type,
                            @Field("client_id") String id,
                            @Field("client_secret") String secret);
    @FormUrlEncoded
    @POST("signup")
    Call<ApiResponse> signup(@Field("email") String email,
                             @Field("password") String password);
    @FormUrlEncoded
    @POST("lang_list")
    Call<ApiResponse> lang_list(@Field("") String s);
    @FormUrlEncoded
    @POST("forgot_pass")
    Call<ApiResponse> forgot_pass(@Field("email") String email);
    @FormUrlEncoded

    @POST("change_pass")
    Call<ApiResponse> change_pass(@Field("oldpass") String oldpass,
                                  @Field("newpass") String newpass,
                                  @Field("userid") String userid);



    @FormUrlEncoded
    @POST("login")
    Call<ApiResponse> login(@Field("username") String username,
                            @Field("password") String password);
}
