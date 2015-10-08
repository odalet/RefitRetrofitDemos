package com.ssg.tech.helloRetrofit;

import com.google.gson.annotations.SerializedName;

public class RenderRequest {

	@SerializedName("text")
	private String text;
	@SerializedName("mode")
	private String mode;
	@SerializedName("context")
	private String context;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
