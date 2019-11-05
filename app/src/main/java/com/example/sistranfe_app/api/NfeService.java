package com.example.sistranfe_app.api;


import com.example.sistranfe_app.model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface NfeService {

    /*
    https://api.github.com/search/
    repositories
    ?q=language:Java
    &sort=stars
    &page=1
    */

    @GET("lstIdeNfeMaisDe")
    Call<Resultado> recuperarRepo(
            @Query("min") String min
    );

}
