package com.ssg.tech.helloRetrofit;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface GitHubApi {	
	
	@Headers("User-Agent: HelloRetrofit")
	@POST("/markdown")
	Call<String> renderAsMarkdown(@Body GitHubRenderRequest request);
}
