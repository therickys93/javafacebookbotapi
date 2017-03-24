package it.therickys93.facebookbot.request;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * class that sets the greeting text
 * @author therickys93
 *
 */
public class SetGreetingText implements Sendable {

	private static final String GREETING = "greeting";
	private static final String TEXT = "text";
	private static final String LOCALE = "locale";
	private String text;
	
	/**
	 * constructs the object with the text
	 * @param text the text to show
	 */
	public SetGreetingText(String text) {
		this.text = text;
	}
	
	@Override
	public JsonObject toJson() {
		JsonObject greeting = new JsonObject();
		greeting.addProperty(LOCALE, "default");
		greeting.addProperty(TEXT, this.text);
		JsonArray array = new JsonArray();
		array.add(greeting);
		JsonObject object = new JsonObject();
		object.add(GREETING, array);
		return object;
	}

	/**
	 * return the text
	 * @return the text
	 */
	public String text() {
		return this.text;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=";
	}

}
