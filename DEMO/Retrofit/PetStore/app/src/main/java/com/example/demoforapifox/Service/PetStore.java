package com.example.demoforapifox.Service;

import com.example.demoforapifox.Model.Pet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PetStore
{
    @POST("pet")
    Call<Pet> CreatePet(@Body Pet pet);
}
