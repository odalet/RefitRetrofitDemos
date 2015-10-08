package com.ssg.tech.helloRetrofit;

import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface GitHubApi {
	@Headers("User-Agent: HelloRetrofit")
	@POST("/markdown")
	Call<ResponseBody> render(@Body RenderRequest request);
}
