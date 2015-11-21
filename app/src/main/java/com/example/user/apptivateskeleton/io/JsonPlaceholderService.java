package com.example.user.apptivateskeleton.io;

import com.example.user.apptivateskeleton.model.Post;
import com.example.user.apptivateskeleton.model.Flickr;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by user on 31/10/2015.
 */
public interface JsonPlaceholderService {

    @GET("/posts/{id}")
    Call<Post> getPosts(@Path("id") String id);

    @GET("?format=json&nojsoncallback=1")
    Call<Flickr> getFlickr();

    @GET("?format=json&nojsoncallback=1")
    Call<Flickr> getSearch( @Query("tags") String tags);
}