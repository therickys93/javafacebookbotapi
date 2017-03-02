package it.therickys93.facebookbot;

import com.google.gson.JsonObject;

public class SendMessage implements SendRequest{

	private String id;
	private String text;
	
	public SendMessage(String id, String text) {
		this.id = id;
		this.text = text;
	}

	public String id() {
		return this.id;
	}

	public String text() {
		return this.text;
	}

	@Override
	public String toJson() {
		JsonObject message = new JsonObject();
		JsonObject rec = new JsonObject();
		rec.addProperty("id", this.id);
		JsonObject mes = new JsonObject();
		mes.addProperty("text", this.text);
		message.add("recipient", rec);
		message.add("message", mes);
		return message.toString();
	}

	
	
}
