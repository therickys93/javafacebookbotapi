package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

/**
 * class that create a Quick Reply
 * @author therickys93
 *
 */
public class QuickReply implements Sendable {

	private static final String PAYLOAD = "payload";
	private static final String TITLE = "title";
	private static final String CONTENT_TYPE = "content_type";
	private String type;
	private String title;
	private String payload;
	
	/**
	 * construct a quick reply
	 * @param type the type of the quick reply
	 * @param title the title of the quick reply
	 * @param payload the payload of the quick reply
	 */
	public QuickReply(String type, String title, String payload) {
		this.type = type;
		this.title = title;
		this.payload = payload;
	}

	/**
	 * return the type of the quick reply
	 * @return the type of the quick reply
	 */
	public String type() {
		return this.type;
	}

	/**
	 * return the title of the quick reply
	 * @return the title of the quick reply
	 */
	public String title() {
		return this.title;
	}

	/**
	 * return the payload of the quick reply
	 * @return the payload of the quick reply 
	 */
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

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messages?access_token=";
	}

}
