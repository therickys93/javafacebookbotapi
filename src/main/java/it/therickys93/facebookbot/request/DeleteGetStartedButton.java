package it.therickys93.facebookbot.request;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DeleteGetStartedButton implements Sendable {	
		
	@Override
	public JsonObject toJson() {
		JsonObject object = new JsonObject();
		JsonArray fields = new JsonArray();
		fields.add("get_started");
		object.add("fields", fields);
		return object;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=";
	}

}
