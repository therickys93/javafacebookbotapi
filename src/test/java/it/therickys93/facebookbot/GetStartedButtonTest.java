package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import it.therickys93.facebookbot.request.DeleteGetStartedButton;
import it.therickys93.facebookbot.request.DeleteGreetingText;
import it.therickys93.facebookbot.request.SetGetStartedButton;
import it.therickys93.facebookbot.request.SetGreetingText;

public class GetStartedButtonTest {

	@Test
	public void testOne() {
		SetGetStartedButton button = new SetGetStartedButton("payload_to_call");
		assertEquals("payload_to_call", button.payload());
		assertEquals("{\"get_started\":{\"payload\":\"payload_to_call\"}}", button.toJson().toString());
	}
	
	@Test
	public void testTwo() {
		DeleteGetStartedButton button = new DeleteGetStartedButton();
		assertEquals("{\"fields\":[\"get_started\"]}", button.toJson().toString());
	}
	
	@Test
	public void testThree() {
		SetGreetingText text = new SetGreetingText("Hello Facebook!");
		assertEquals("Hello Facebook!", text.text());
		assertEquals("{\"greeting\":[{\"locale\":\"default\",\"text\":\"Hello Facebook!\"}]}", text.toJson().toString());
	}
		
	@Test
	public void testFour() {
		DeleteGreetingText text = new DeleteGreetingText();
		assertEquals("{\"fields\":[\"greeting\"]}", text.toJson().toString());
	}
	
	public void usageSetGetStartedButton() throws IOException {
		FacebookBot bot = new FacebookBot("TOKEN");
		String response = bot.execute(new SetGetStartedButton("payload"));
		response.toString();
	}
	
}
