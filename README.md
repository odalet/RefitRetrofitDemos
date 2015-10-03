# RefitRetrofitDemos

Example uses of both [Refit (.NET)](https://github.com/paulcbetts/refit) and [Retrofit (Java)](https://github.com/square/retrofit).

You'll find the same 'Hello World' example implemented with both libraries.
This sample invokes the GitHub Markdown API, passing-it a string and retrieves the equivalent HTML. Note that the request body is Json whereas the response is a raw string.

Note that in the Java implementation, I had to provide my own Converter Factory to Retrofit, because it seems not to like raw string responses. 
If anyone knows of a better to handle this situation, I'd appreciate insights.
