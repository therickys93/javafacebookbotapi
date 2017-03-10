package it.therickys93.facebookbot;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SendMessage implements Sendable{

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
		rec.addProperty("id", this.id);
		JsonObject mes = new JsonObject();
		mes.addProperty("text", this.text);
		message.add("recipient", rec);
		if(this.replies != null){
			JsonArray repliesArray = new JsonArray();
			for(int index = 0; index < this.replies.size(); index++){
				repliesArray.add(this.replies.get(index).toJson());
			}
			mes.add("quick_replies", repliesArray);
		}
		message.add("message", mes);
		return message;
	}

	public void addQuickReplies(List<QuickReply> replies) {
		this.replies = replies;
	}

	
	
}
