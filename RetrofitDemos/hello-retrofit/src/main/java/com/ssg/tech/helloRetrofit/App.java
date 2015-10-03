package com.ssg.tech.helloRetrofit;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import com.squareup.okhttp.ResponseBody;

public class App {
	private static final String BASE_API_URL = "https://api.github.com";

	public static void main(String[] args) {

		// Simple initialization of Retrofit
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_API_URL) //
				.addConverterFactory(GsonConverterFactory.create()).build();
		// Create an instance of our GitHub API interface.
		GitHubApi api = retrofit.create(GitHubApi.class);

		GitHubRenderRequest request = new GitHubRenderRequest();
		request.setText("**Hello**, [Refit](https://github.com/paulcbetts/refit)!");
		request.setMode("markdown");
		request.setContext("");

		Call<ResponseBody> call = api.renderAsMarkdown(request);

		try {
			String html = call.execute().body().string();
			System.out.println(html);
		} catch (IOException e) {
			System.err.println("Github API Invocation failed: " + e);
		}
	}
}
