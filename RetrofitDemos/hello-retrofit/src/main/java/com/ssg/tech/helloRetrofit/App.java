package com.ssg.tech.helloRetrofit;

import java.io.IOException;

import retrofit.Call;
import retrofit.MyConverterFactory;
import retrofit.Retrofit;

public class App {
	
	private static final String BASE_URL = "https://api.github.com";

	public static void main(String[] args) {
		String md = "**Hello**, [Retrofit](https://github.com/square/retrofit)!";
		String html = convertToHtml(md);
		System.out.println(html);
	}

	private static String convertToHtml(String markdown) {
		// NB: We need a custom converter factory that:
		// * Transforms the request into Json
		// * But returns the raw string in the response.
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(MyConverterFactory.create()).build();

		// Prepare the request
		GitHubRenderRequest request = new GitHubRenderRequest();
		request.setText(markdown);
		request.setMode("markdown");

		// Create an instance of our GitHub API interface.
		GitHubApi api = retrofit.create(GitHubApi.class);
		Call<String> call = api.renderAsMarkdown(request);

		try {
			return call.execute().body();
		} catch (IOException e) {
			System.err.println("Github API Invocation faile: " + e);
		}

		return "";
	}
}
