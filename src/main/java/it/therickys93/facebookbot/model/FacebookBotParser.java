package it.therickys93.facebookbot.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FacebookBotParser {

	private static final String MESSAGE_QUICK_REPLY_PAYLOAD = "payload";
	private static final String MESSAGE_QUICK_REPLY = "quick_reply";
	private static final String MESSAGE_TEXT = "text";
	private static final String MESSAGE_SEQ = "seq";
	private static final String MESSAGE_ID = "mid";
	private static final String MESSAGE = "message";
	private static final String MESSAGING_TIMESTAMP = "timestamp";
	private static final String MESSAGING_RECIPIENT = "recipient";
	private static final String MESSAGING_SENDER = "sender";
	private static final String MESSAGING = "messaging";
	private static final String ENTRY_TIME = "time";
	private static final String ENTRY_ID = "id";
	private static final String ENTRY = "entry";
	private static final String OBJECT = "object";

	public static Payload parsePayload(String newMessage) {
		Payload message = new Payload();
		JsonParser parser = new JsonParser();
		JsonObject object = parser.parse(newMessage).getAsJsonObject();
		message.object = object.get(OBJECT).getAsString();
		try {
			message.entry = parseEntry(object.get(ENTRY).getAsJsonArray().get(0));
			message.ok = true;
		} catch(NullPointerException e) {
			message.ok = false;
		}
		return message;
	}
	
	private static Entry parseEntry(JsonElement newEntry) {
		JsonObject object = newEntry.getAsJsonObject();
		Entry entry = new Entry();
		entry.id = object.get(ENTRY_ID).getAsString();
		entry.time = object.get(ENTRY_TIME).getAsBigInteger();
		entry.messaging = parseMessagging(object.get(MESSAGING).getAsJsonArray().get(0));
		return entry;
	}

	private static Messaging parseMessagging(JsonElement jsonElement) {
		JsonObject object = jsonElement.getAsJsonObject();
		Messaging messagging = new Messaging();
		messagging.senderId = object.get(MESSAGING_SENDER).getAsJsonObject().get(ENTRY_ID).getAsString();
		messagging.recipientId = object.get(MESSAGING_RECIPIENT).getAsJsonObject().get(ENTRY_ID).getAsString();
		messagging.timestamp = object.get(MESSAGING_TIMESTAMP).getAsBigInteger();
		if(object.get("postback") != null) {
			messagging.postbackPayload = object.get("postback").getAsJsonObject().get("payload").getAsString();
		} else {
			messagging.message = parseMessage(object.get(MESSAGE).getAsJsonObject());
		}
		return messagging;
	}

	private static Message parseMessage(JsonObject jsonObject) {
		Message message = new Message();
		try {
			message.id = jsonObject.get(MESSAGE_ID).getAsString();
			message.seq = jsonObject.get(MESSAGE_SEQ).getAsBigInteger().intValue();
			message.text = jsonObject.get(MESSAGE_TEXT).getAsString();
			if(jsonObject.get(MESSAGE_QUICK_REPLY) != null){
				message.quickReplyText = jsonObject.get(MESSAGE_QUICK_REPLY).getAsJsonObject().get(MESSAGE_QUICK_REPLY_PAYLOAD).getAsString();
			} else {
				message.quickReplyText = null;
			}
		} catch (NullPointerException e){
			message = null;
		}
		return message;
	}
	
}
