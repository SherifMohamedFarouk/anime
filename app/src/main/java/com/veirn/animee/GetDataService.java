package com.veirn.animee;

import com.veirn.animee.Model.AnimeCh;
import com.veirn.animee.Model.TopAnime;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("/v3/anime/1/characters_staff/")
    Call<AnimeCh> getAllCH();

    @GET ("v3/top/anime/{page}")
     Call<TopAnime> gettopanime(@Path(value = "page")String page);


    //@GET ("/anime/{page}")
   // Call<TopAnime> gettopanime(@Path(value = "page")String page);

        }
