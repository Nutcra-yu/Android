package com.example.demoforapifox2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Blackboard
{
    @POST("login")
    Call<BACK> login(@Body SEND send);

}
