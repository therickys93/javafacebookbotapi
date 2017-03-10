package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

public class QuickReply implements Sendable {

	private static final String PAYLOAD = "payload";
	private static final String TITLE = "title";
	private static final String CONTENT_TYPE = "content_type";
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
		jsonObject.addProperty(CONTENT_TYPE, this.type);
		jsonObject.addProperty(TITLE, this.title);
		jsonObject.addProperty(PAYLOAD, this.payload);
		return jsonObject;
	}

}
