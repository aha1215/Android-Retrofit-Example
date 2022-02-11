package com.student.library.apis;


import com.student.library.models.VolumesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *  Interface for Retrofit2 communication with real HTTP API
 */

public interface BookSearchService {

    //Retrofit2 GET request
    @GET("/books/v1/volumes")
    Call<VolumesResponse> searchVolumes(
            @Query("q") String query,
            @Query("inauthor") String author,
            @Query("key") String apiKey
    );

    //Optional: Can add POST request
}
