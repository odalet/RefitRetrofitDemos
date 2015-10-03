package com.ssg.tech.helloRetrofit.converters;

import java.io.IOException;
import java.io.Reader;

import com.squareup.okhttp.ResponseBody;

import retrofit.Converter;

public class StringResponseBodyConverter implements Converter<ResponseBody, String> {

	@Override
	public String convert(ResponseBody value) throws IOException {
		Reader reader = value.charStream();
		try {
			return readToString(reader);
		} finally {
			try {
				reader.close();
			} catch (IOException ignored) {
			}
		}
	}

	private static String readToString(Reader reader) throws IOException {
		char[] arr = new char[8 * 1024];
		StringBuilder buffer = new StringBuilder();
		int numCharsRead;
		while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
			buffer.append(arr, 0, numCharsRead);
		}

		return buffer.toString();
	}
}
