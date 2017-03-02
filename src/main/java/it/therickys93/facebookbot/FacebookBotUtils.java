package it.therickys93.facebookbot;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FacebookBotUtils {

	public static Payload parsePayload(String newMessage) {
		Payload message = new Payload();
		JsonParser parser = new JsonParser();
		JsonObject object = parser.parse(newMessage).getAsJsonObject();
		message.object = object.get("object").getAsString();
		message.entry = parseEntry(object.get("entry").getAsJsonArray().get(0));
		return message;
	}
	
	private static Entry parseEntry(JsonElement newEntry) {
		JsonObject object = newEntry.getAsJsonObject();
		Entry entry = new Entry();
		entry.id = object.get("id").getAsString();
		entry.time = object.get("time").getAsBigInteger();
		entry.messaging = parseMessagging(object.get("messaging").getAsJsonArray().get(0));
		return entry;
	}

	private static Messaging parseMessagging(JsonElement jsonElement) {
		JsonObject object = jsonElement.getAsJsonObject();
		Messaging messagging = new Messaging();
		messagging.senderId = object.get("sender").getAsJsonObject().get("id").getAsString();
		messagging.recipientId = object.get("recipient").getAsJsonObject().get("id").getAsString();
		messagging.timestamp = object.get("timestamp").getAsBigInteger();
		messagging.message = parseMessage(object.get("message").getAsJsonObject());
		return messagging;
	}

	private static Message parseMessage(JsonObject jsonObject) {
		Message message = new Message();
		message.id = jsonObject.get("mid").getAsString();
		message.seq = jsonObject.get("seq").getAsBigInteger().intValue();
		message.text = jsonObject.get("text").getAsString();
		return message;
	}

	
	
}
