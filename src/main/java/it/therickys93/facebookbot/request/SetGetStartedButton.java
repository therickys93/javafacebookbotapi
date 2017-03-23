package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

public class SetGetStartedButton implements Sendable {

	private static final String GET_STARTED = "get_started";
	private static final String PAYLOAD = "payload";
	private String payload;
	
	public SetGetStartedButton(String payload) {
		this.payload = payload;
	}

	@Override
	public JsonObject toJson() {
		JsonObject get_started = new JsonObject();
		JsonObject payload = new JsonObject();
		payload.addProperty(PAYLOAD, this.payload);
		get_started.add(GET_STARTED, payload);
		return get_started;
	}

	public String payload() {
		return this.payload;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=";
	}

}
