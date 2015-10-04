package com.ssg.tech.helloRetrofit;

import java.io.IOException;

import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class App {

	private static final String BASE_URL = "https://api.github.com";

	public static void main(String[] args) {
		String md = "**Hello**, [Retrofit](https://github.com/square/retrofit)!";
		String html = convertToHtml(md);
		System.out.println(html);
	}

	private static String convertToHtml(String markdown) {
		// Simple initialization of Retrofit
		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL) //
				.addConverterFactory(GsonConverterFactory.create()).build();

		// Prepare the request
		GitHubRenderRequest request = new GitHubRenderRequest();
		request.setText(markdown);
		request.setMode("markdown");

		GitHubApi api = retrofit.create(GitHubApi.class);
		Call<ResponseBody> call = api.renderAsMarkdown(request);

		try {
			String html = call.execute().body().string();
			System.out.println(html);
		} catch (IOException e) {
			System.err.println("Github API Invocation failed: " + e);
		}

		return "";
	}
}
