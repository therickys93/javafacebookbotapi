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
	
	@Test
	public void testTwo() {
		Hub hub = new Hub(createFalseWebhookTest(), "MY_SECRET_TOKEN");
		assertEquals("HUB_MODE", hub.mode());
		assertEquals("CHALLENGE_FROM_FACEBOOK", hub.challenge());
		assertEquals("MY_SECRET_TOKEN", hub.token());
		assertTrue(hub.ok());
	}
	
	@Test
	public void testThree() {
		Hub hub = new Hub(createFalseWebhookTest(), "MY_SECRET_WRONG_TOKEN");
		assertEquals("HUB_MODE", hub.mode());
		assertEquals("CHALLENGE_FROM_FACEBOOK", hub.challenge());
		assertEquals("MY_SECRET_TOKEN", hub.token());
		assertFalse(hub.ok());
	}
	
	@Test
	public void testFour() {
		assertEquals("Failed validation. Make sure the validation tokens match.", Hub.TOKEN_ERROR);
	}
	
	public String usage() {
		Hub hub = new Hub(createFalseWebhookTest(), "MY_SECRET_TOKEN");
		if(hub.ok()){
			return hub.challenge(); 
		} else {
			return Hub.TOKEN_ERROR;
		}
	}
	
	private Map<String, String> createFalseWebhookTest() {
		Map<String, String> webhook = new HashMap<String, String>();
		webhook.put("hub.mode", "HUB_MODE");
		webhook.put("hub.challenge", "CHALLENGE_FROM_FACEBOOK");
		webhook.put("hub.verify_token", "MY_SECRET_TOKEN");
		return webhook;
	}
	
}
