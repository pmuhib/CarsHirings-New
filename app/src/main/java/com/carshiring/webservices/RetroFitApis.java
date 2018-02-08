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
}
