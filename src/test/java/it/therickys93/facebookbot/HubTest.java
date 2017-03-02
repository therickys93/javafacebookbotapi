package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HubTest {

	@Test
	public void testOne() {
		Hub hub = new Hub(createFalseWebhookTest());
		assertEquals("HUB_MODE", hub.mode());
		assertEquals("CHALLENGE_FROM_FACEBOOK", hub.challenge());
		assertEquals("MY_SECRET_TOKEN", hub.token());
	}
	
	private Map<String, String> createFalseWebhookTest() {
		Map<String, String> webhook = new HashMap<String, String>();
		webhook.put("hub.mode", "HUB_MODE");
		webhook.put("hub.challenge", "CHALLENGE_FROM_FACEBOOK");
		webhook.put("hub.verify_token", "MY_SECRET_TOKEN");
		return webhook;
	}
	
}
