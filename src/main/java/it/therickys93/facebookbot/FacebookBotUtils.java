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
		try {
			message.entry = parseEntry(object.get("entry").getAsJsonArray().get(0));
			message.ok = true;
		} catch(NullPointerException e) {
			message.ok = false;
		}
		return message;
	}
	
	private static Entry parseEntry(JsonElement newEntry) throws NullPointerException {
		JsonObject object = newEntry.getAsJsonObject();
		Entry entry = new Entry();
		entry.id = object.get("id").getAsString();
		entry.time = object.get("time").getAsBigInteger();
		entry.messaging = parseMessagging(object.get("messaging").getAsJsonArray().get(0));
		return entry;
	}

	private static Messaging parseMessagging(JsonElement jsonElement) throws NullPointerException{
		JsonObject object = jsonElement.getAsJsonObject();
		Messaging messagging = new Messaging();
		messagging.senderId = object.get("sender").getAsJsonObject().get("id").getAsString();
		messagging.recipientId = object.get("recipient").getAsJsonObject().get("id").getAsString();
		messagging.timestamp = object.get("timestamp").getAsBigInteger();
		messagging.message = parseMessage(object.get("message").getAsJsonObject());
		return messagging;
	}

	private static Message parseMessage(JsonObject jsonObject) throws NullPointerException {
		Message message = new Message();
		message.id = jsonObject.get("mid").getAsString();
		message.seq = jsonObject.get("seq").getAsBigInteger().intValue();
		message.text = jsonObject.get("text").getAsString();
		if(jsonObject.get("quick_reply") != null){
			message.quickReplyText = jsonObject.get("quick_reply").getAsJsonObject().get("payload").getAsString();
		} else {
			message.quickReplyText = null;
		}
		return message;
	}
	
}
