package com.veirn.animee;

import com.veirn.animee.Model.AnimeCh;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/v3/anime/1/character_staff/")
    Call<AnimeCh> getAllCH();
        }