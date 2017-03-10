package it.therickys93.facebookbot.request;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SendMessage implements Sendable{

	private static final String MESSAGE = "message";
	private static final String QUICK_REPLIES = "quick_replies";
	private static final String RECIPIENT = "recipient";
	private static final String TEXT = "text";
	private static final String ID = "id";
	private String id;
	private String text;
	private List<QuickReply> replies = null;
	
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
	public JsonObject toJson() {
		JsonObject message = new JsonObject();
		JsonObject rec = new JsonObject();
		rec.addProperty(ID, this.id);
		JsonObject mes = new JsonObject();
		mes.addProperty(TEXT, this.text);
		message.add(RECIPIENT, rec);
		if(this.replies != null){
			JsonArray repliesArray = new JsonArray();
			for(int index = 0; index < this.replies.size(); index++){
				repliesArray.add(this.replies.get(index).toJson());
			}
			mes.add(QUICK_REPLIES, repliesArray);
		}
		message.add(MESSAGE, mes);
		return message;
	}

	public void addQuickReplies(List<QuickReply> replies) {
		this.replies = replies;
	}

	
	
}
