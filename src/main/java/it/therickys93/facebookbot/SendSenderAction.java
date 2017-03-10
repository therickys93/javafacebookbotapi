package it.therickys93.facebookbot;

import com.google.gson.JsonObject;

public class SendSenderAction implements Sendable{

	private String id;
	private String chatAction;
	
	public SendSenderAction(String id, String chatAction) {
		this.id = id;
		this.chatAction = chatAction;
	}

	public String id() {
		return this.id;
	}

	public String action() {
		return this.chatAction;
	}

	@Override
	public JsonObject toJson() {
		JsonObject message = new JsonObject();
		JsonObject rec = new JsonObject();
		rec.addProperty("id", this.id);
		message.add("recipient", rec);
		message.addProperty("sender_action", this.chatAction);
		return message;
	}

}
