package it.therickys93.facebookbot;

import java.io.IOException;

import it.therickys93.facebookbot.request.Sendable;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FacebookBot {
	
	private static final String APPLICATION_JSON = "application/json; charset=utf-8";
	private String token;
	OkHttpClient client;
	
	public FacebookBot(String token) {
		this.token = token;
		client = new OkHttpClient();
	}

	public String token() {
		return this.token;
	}
	
	public String execute(Sendable request) throws IOException {
		final MediaType JSON = MediaType.parse(APPLICATION_JSON);
		RequestBody body = RequestBody.create(JSON, request.toJson().toString());
		Request requestAdd = new Request.Builder().url(request.endpoint() + this.token).post(body).build();
		Response response = client.newCall(requestAdd).execute();
		return response.body().string();
	}

}
