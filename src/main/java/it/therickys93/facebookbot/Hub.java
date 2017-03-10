package it.therickys93.facebookbot;

import java.util.Map;

public class Hub {

	private static final String HUB_VERIFY_TOKEN = "hub.verify_token";
	private static final String HUB_CHALLENGE = "hub.challenge";
	private static final String HUB_MODE = "hub.mode";
	public static final String TOKEN_ERROR = "Failed validation. Make sure the validation tokens match.";
	private Map<String, String> webhook;
	private String tokenToVerify;
	
	public Hub(Map<String, String> createFalseWebhookTest) {
		this.webhook = createFalseWebhookTest;
	}

	public Hub(Map<String, String> createFalseWebhookTest, String tokenToVerify) {
		this(createFalseWebhookTest);
		this.tokenToVerify = tokenToVerify;
	}

	public String mode() {
		return this.webhook.get(HUB_MODE);
	}

	public String challenge() {
		return this.webhook.get(HUB_CHALLENGE);
	}

	public String token() {
		return this.webhook.get(HUB_VERIFY_TOKEN);
	}

	public boolean ok() {
		return this.webhook.get(HUB_VERIFY_TOKEN).equals(this.tokenToVerify);
	}

}
