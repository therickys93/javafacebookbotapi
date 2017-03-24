package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.facebookbot.request.DeleteGetStartedButton;
import it.therickys93.facebookbot.request.DeleteGreetingText;
import it.therickys93.facebookbot.request.Locale;
import it.therickys93.facebookbot.request.QuickReply;
import it.therickys93.facebookbot.request.SendMessage;
import it.therickys93.facebookbot.request.SendSenderAction;
import it.therickys93.facebookbot.request.SetGetStartedButton;
import it.therickys93.facebookbot.request.SetGreetingText;

public class EndpointTest {

	@Test
	public void testMessageEndpoint() {
		assertEquals(messageEndpoint(), new QuickReply("", "", "").endpoint());
		assertEquals(messageEndpoint(), new SendMessage("", "").endpoint());
		assertEquals(messageEndpoint(), new SendSenderAction("", "").endpoint());
	}
	
	@Test
	public void testProfileEndpoint() {
		assertEquals(profileEndpoint(), new DeleteGetStartedButton().endpoint());
		assertEquals(profileEndpoint(), new DeleteGreetingText().endpoint());
		assertEquals(profileEndpoint(), new SetGetStartedButton("").endpoint());
		assertEquals(profileEndpoint(), new SetGreetingText("", Locale.DEFAULT.toString()).endpoint());
	}
	
	private String messageEndpoint(){
		return "https://graph.facebook.com/v2.6/me/messages?access_token=";
	}
	
	private String profileEndpoint() {
		return "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=";
	}
	
}
