# RefitRetrofitDemos

Example uses of both [Refit (.NET)](https://github.com/paulcbetts/refit) and [Retrofit (Java)](https://github.com/square/retrofit).

You'll find the same 'Hello World' example implemented with both libraries.
This sample invokes the GitHub Markdown API, passing-it a string and retrieves the translated HTML. 

Note that, in this API, the request body is Json whereas the response is a raw string. In the Java case, there's a trick to apply to prevent Retrofit from trying to parse the response as Json: one must return a `ResponseBody` object instead of a `String`. Thanks [@devnied](https://github.com/devnied) for providing the solution.
