# RefitRetrofitDemos

Example uses of both [Refit (.NET)](https://github.com/paulcbetts/refit) and [Retrofit (Java)](https://github.com/square/retrofit).

You'll find the same 'Hello World' example implemented with both libraries.
This sample invokes the GitHub Markdown API, passing-it a string and retrieves the translated HTML. 

Note that, in this API, the request body is Json whereas the response is a raw string. There's a trick apply to prevent Retrofit from trying to decode the response as Json: one must return a `ResponseBody` object instead of a `String`. Thanks @devnied for providing the solution. 

Note that in the Java implementation, I had to provide my own Converter Factory to Retrofit, because it seems not to like raw string responses. 
If anyone knows of a better to handle this situation, I'd appreciate insights.
