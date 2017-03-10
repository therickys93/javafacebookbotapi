package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

public class SetGetStartedButton implements Sendable {

	private String payload;
	
	public SetGetStartedButton(String payload) {
		this.payload = payload;
	}

	@Override
	public JsonObject toJson() {
		JsonObject get_started = new JsonObject();
		JsonObject payload = new JsonObject();
		payload.addProperty("payload", this.payload);
		get_started.add("get_started", payload);
		return get_started;
	}

	public String payload() {
		return this.payload;
	}

}
