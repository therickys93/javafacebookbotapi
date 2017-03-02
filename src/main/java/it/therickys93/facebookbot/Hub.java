package it.therickys93.facebookbot;

import java.util.Map;

public class Hub {

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
		return this.webhook.get("hub.mode");
	}

	public String challenge() {
		return this.webhook.get("hub.challenge");
	}

	public String token() {
		return this.webhook.get("hub.verify_token");
	}

	public boolean ok() {
		return this.webhook.get("hub.verify_token").equals(this.tokenToVerify);
	}

}
