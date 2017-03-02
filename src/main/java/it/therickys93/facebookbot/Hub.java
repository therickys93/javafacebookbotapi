package it.therickys93.facebookbot;

import java.util.Map;

public class Hub {

	private Map<String, String> webhook;
	
	public Hub(Map<String, String> createFalseWebhookTest) {
		this.webhook = createFalseWebhookTest;
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

}
