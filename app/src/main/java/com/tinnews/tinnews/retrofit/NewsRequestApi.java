package com.tinnews.tinnews.retrofit;

import com.tinnews.tinnews.retrofit.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dxie on 12/28/18.
 */

// https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=060a2986fed14a59a58496091653c7c0
public interface NewsRequestApi {
    @GET("top-headlines")
    Observable<BaseResponse> getNewsByCountry(@Query("country") String country);
}
