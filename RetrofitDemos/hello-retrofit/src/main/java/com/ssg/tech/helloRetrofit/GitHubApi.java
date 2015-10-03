package com.ssg.tech.helloRetrofit;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

import com.squareup.okhttp.ResponseBody;

public interface GitHubApi {
	@Headers("User-Agent: HelloRetrofit")
	@POST("/markdown")
	Call<ResponseBody> renderAsMarkdown(@Body GitHubRenderRequest request);
}
