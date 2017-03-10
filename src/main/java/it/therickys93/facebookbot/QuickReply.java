package it.therickys93.facebookbot;

import com.google.gson.JsonObject;

public class QuickReply implements Sendable {

	private String type;
	private String title;
	private String payload;
	
	public QuickReply(String type, String title, String payload) {
		this.type = type;
		this.title = title;
		this.payload = payload;
	}

	public static final String TEXT = "text";

	public String type() {
		return this.type;
	}

	public String title() {
		return this.title;
	}

	public String payload() {
		return this.payload;
	}

	@Override
	public JsonObject toJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("content_type", this.type);
		jsonObject.addProperty("title", this.title);
		jsonObject.addProperty("payload", this.payload);
		return jsonObject;
	}

}
