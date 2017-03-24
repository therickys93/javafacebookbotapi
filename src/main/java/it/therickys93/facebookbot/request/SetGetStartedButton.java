package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

/**
 * class that sets the Get Started button
 * @author therickys93
 *
 */
public class SetGetStartedButton implements Sendable {

	private static final String GET_STARTED = "get_started";
	private static final String PAYLOAD = "payload";
	private String payload;
	
	/**
	 * create the object with the payload to send back when the button is pressed
	 * @param payload the payload that facebook send back when the button is pressed
	 */
	public SetGetStartedButton(String payload) {
		this.payload = payload;
	}

	@Override
	public JsonObject toJson() {
		JsonObject get_started = new JsonObject();
		JsonObject payload = new JsonObject();
		payload.addProperty(PAYLOAD, this.payload);
		get_started.add(GET_STARTED, payload);
		return get_started;
	}

	/**
	 * return the payload
	 * @return the payload
	 */
	public String payload() {
		return this.payload;
	}

	@Override
	public String endpoint() {
		return "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=";
	}

}
