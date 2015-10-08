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

		GitHubApi api = retrofit.create(GitHubApi.class);
		
		// Prepare the request
		RenderRequest request = new RenderRequest();
		request.setText(markdown);
		request.setMode("markdown");

		Call<ResponseBody> call = api.render(request);

		try {
			return call.execute().body().string();
		} catch (IOException e) {
			System.err.println("Github API Invocation failed: " + e);
		}

		return "";
	}
}
