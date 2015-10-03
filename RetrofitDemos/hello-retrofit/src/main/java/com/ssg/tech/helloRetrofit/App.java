package com.ssg.tech.helloRetrofit;

import java.io.IOException;

import com.google.gson.Gson;
import com.ssg.tech.helloRetrofit.converters.MyConverterFactory;

import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

public class App {
	private static final String BASE_API_URL = "https://api.github.com";

	public static void main(String[] args) {

		// Simple initialization of Retrofit
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_API_URL)
				.addConverterFactory(MyConverterFactory.create()).build();
		// Create an instance of our GitHub API interface.
		GitHubApi api = retrofit.create(GitHubApi.class);

		GitHubRenderRequest request = new GitHubRenderRequest();
		request.setText("**Hello**, [Refit](https://github.com/paulcbetts/refit)!");
		request.setMode("markdown");
		request.setContext("");

		Call<String> call = api.renderAsMarkdown(request);

		try {
			String html = call.execute().body();
			System.out.println(html);
		} catch (IOException e) {
			System.err.println("Github API Invocation faile: " + e);
		}
	}
}
