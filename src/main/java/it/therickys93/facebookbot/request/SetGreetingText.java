package it.therickys93.facebookbot.request;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SetGreetingText implements Sendable {

	private String text;
	
	public SetGreetingText(String text) {
		this.text = text;
	}
	
	@Override
	public JsonObject toJson() {
		JsonObject greeting = new JsonObject();
		greeting.addProperty("locale", "default");
		greeting.addProperty("text", this.text);
		JsonArray array = new JsonArray();
		array.add(greeting);
		JsonObject object = new JsonObject();
		object.add("greeting", array);
		return object;
	}

	public String text() {
		return this.text;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=";
	}

}
