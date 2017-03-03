package it.therickys93.facebookbot;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FacebookBot {

	public static final String API_URL = "https://graph.facebook.com/v2.6/me/messages?access_token=";
	private String token;
	String endpoint;
	OkHttpClient client;
	
	public FacebookBot(String token) {
		this.token = token;
		this.endpoint = API_URL + token;
		client = new OkHttpClient();
	}

	public String token() {
		return this.token;
	}
	
	public String execute(SendRequest request) throws IOException {
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		RequestBody body = RequestBody.create(JSON, request.toJson().toString());
		Request requestAdd = new Request.Builder().url(this.endpoint).post(body).build();
		Response response = client.newCall(requestAdd).execute();
		return response.body().string();
	}

}
