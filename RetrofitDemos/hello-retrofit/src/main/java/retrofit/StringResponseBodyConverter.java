package retrofit;

import java.io.IOException;
import java.io.Reader;

import com.squareup.okhttp.ResponseBody;

import retrofit.Converter;

// Package visibility so that we are consistent with Retrofit's own converters
class StringResponseBodyConverter implements Converter<ResponseBody, String> {

	@Override
	public String convert(ResponseBody value) throws IOException {
		try (Reader reader = value.charStream()) {
			return readToString(reader);
		}
	}

	// Adapted from http://www.baeldung.com/java-convert-reader-to-string
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
