package it.therickys93.facebookbot;

import java.util.Map;

/**
 * class that works with the challenge given by Facebook when you create the Webhook
 * @author therickys93
 *
 */
public class Hub {

	private static final String HUB_VERIFY_TOKEN = "hub.verify_token";
	private static final String HUB_CHALLENGE = "hub.challenge";
	private static final String HUB_MODE = "hub.mode";
	/**
	 * string that said that something goes wrong
	 */
	public static final String TOKEN_ERROR = "Failed validation. Make sure the validation tokens match.";
	private Map<String, String> webhook;
	private String tokenToVerify;
	
	/**
	 * contructs an object with the request from Facebook
	 * @param webhook the request that come from Facebook
	 */
	public Hub(Map<String, String> webhook) {
		this.webhook = webhook;
	}

	/**
	 * constructs an object with the request from Facebook and the Token
	 * @param webhook the request that come from Facebook
	 * @param tokenToVerify token that you give to Facebook
	 */
	public Hub(Map<String, String> webhook, String tokenToVerify) {
		this(webhook);
		this.tokenToVerify = tokenToVerify;
	}
	
	/**
	 * return the mode of the challenge
	 * @return the mode of the challenge
	 */
	public String mode() {
		return this.webhook.get(HUB_MODE);
	}

	/**
	 * return the challenge 
	 * @return the challenge
	 */
	public String challenge() {
		return this.webhook.get(HUB_CHALLENGE);
	}

	/**
	 * return the token given to verify
	 * @return the token to verify 
	 */
	public String token() {
		return this.webhook.get(HUB_VERIFY_TOKEN);
	}

	/**
	 * return if the token send by Facebook is equals with the token that you give in the constructor
	 * @return the result of the expression
	 */
	public boolean ok() {
		return this.webhook.get(HUB_VERIFY_TOKEN).equals(this.tokenToVerify);
	}

}
