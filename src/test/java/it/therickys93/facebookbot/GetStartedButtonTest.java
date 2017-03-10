package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.facebookbot.request.SetGetStartedButton;

public class GetStartedButtonTest {

	@Test
	public void testOne() {
		SetGetStartedButton button = new SetGetStartedButton("payload_to_call");
		assertEquals("payload_to_call", button.payload());
		assertEquals("{\"get_started\":{\"payload\":\"payload_to_call\"}}", button.toJson().toString());
	}
	
}
