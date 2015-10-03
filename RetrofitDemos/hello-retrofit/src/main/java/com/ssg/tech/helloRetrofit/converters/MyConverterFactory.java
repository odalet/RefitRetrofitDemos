package com.ssg.tech.helloRetrofit.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.security.InvalidParameterException;

import com.google.gson.Gson;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import retrofit.Converter;

public class MyConverterFactory extends Converter.Factory {
	public static MyConverterFactory create() {
		return create(new Gson());
	}

	public static MyConverterFactory create(Gson gson) {
		return new MyConverterFactory(gson);
	}

	private final Gson gson;

	private MyConverterFactory(Gson gson) {
		if (gson == null)
			throw new NullPointerException("gson == null");
		this.gson = gson;
	}

	@Override
	public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
		if (type != String.class) {
			throw new InvalidParameterException("Unsupported Type: type must be String.class");
		}
		return new StringResponseBodyConverter();
	}

	@Override
	public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
		return new JsonRequestBodyConverter<>(gson, type);
	}
}
