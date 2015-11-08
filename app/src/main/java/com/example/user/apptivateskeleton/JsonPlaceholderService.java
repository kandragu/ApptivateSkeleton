package com.example.user.apptivateskeleton;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by user on 31/10/2015.
 */
public interface JsonPlaceholderService {

    @GET("/posts/{id}")
    Call<Post> getPosts(@Path("id") String id);
}