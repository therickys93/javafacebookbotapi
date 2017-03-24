package it.therickys93.facebookbot.request;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * class that send the message
 * @author therickys93
 *
 */
public class SendMessage implements Sendable{

	private static final String MESSAGE = "message";
	private static final String QUICK_REPLIES = "quick_replies";
	private static final String RECIPIENT = "recipient";
	private static final String TEXT = "text";
	private static final String ID = "id";
	private String id;
	private String text;
	private List<QuickReply> replies = null;
	
	/**
	 * contructor that create the message
	 * @param id the id of the person
	 * @param text the text to send
	 */
	public SendMessage(String id, String text) {
		this.id = id;
		this.text = text;
	}

	/**
	 * return the id of the person
	 * @return the id of the person
	 */
	public String id() {
		return this.id;
	}

	/**
	 * return the text of the person
	 * @return the text of the person
	 */
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

	/**
	 * add a list of quick replies objects
	 * @param replies the quick replies objects to send with the message
	 */
	public void addQuickReplies(List<QuickReply> replies) {
		this.replies = replies;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messages?access_token=";
	}

	
	
}
