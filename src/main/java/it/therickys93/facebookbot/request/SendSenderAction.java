package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

/**
 * class the send the action
 * @author therickys93
 *
 */
public class SendSenderAction implements Sendable{

	private static final String SENDER_ACTION = "sender_action";
	private static final String RECIPIENT = "recipient";
	private static final String ID = "id";
	private String id;
	private String chatAction;
	
	/**
	 * contruct the action
	 * @param id the id of the person
	 * @param chatAction the action to perform
	 */
	public SendSenderAction(String id, String chatAction) {
		this.id = id;
		this.chatAction = chatAction;
	}

	/**
	 * return the id of the person
	 * @return the id of the person
	 */
	public String id() {
		return this.id;
	}

	/**
	 * return the action of the person
	 * @return the action of the person
	 */
	public String action() {
		return this.chatAction;
	}

	@Override
	public JsonObject toJson() {
		JsonObject message = new JsonObject();
		JsonObject rec = new JsonObject();
		rec.addProperty(ID, this.id);
		message.add(RECIPIENT, rec);
		message.addProperty(SENDER_ACTION, this.chatAction);
		return message;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messages?access_token=";
	}

}
