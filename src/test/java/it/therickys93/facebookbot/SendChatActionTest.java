package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SendChatActionTest {

	@Test
	public void testOne() {
		assertEquals("typing_on", SenderAction.TYPING_ON);
		assertEquals("typing_off", SenderAction.TYPING_OFF);
		assertEquals("mark_seen", SenderAction.MARK_SEEN);
	}
	
	@Test
	public void testTwo() {
		SendSenderAction chatAction = new SendSenderAction("USER_ID", SenderAction.TYPING_ON);
		assertEquals("USER_ID", chatAction.id());
		assertEquals("typing_on", chatAction.action());
		assertEquals("{\"recipient\":{\"id\":\"USER_ID\"},\"sender_action\":\"typing_on\"}", chatAction.toJson().toString());
	}
	
	@Test
	public void testIncreaseCodeCoverage() {
		SenderAction chatAction = new SenderAction();
		chatAction.toString();
	}
	
	public void usage() throws IOException {
		FacebookBot bot = new FacebookBot("TOKEN");
		String response = bot.execute(new SendSenderAction("USER_ID", SenderAction.TYPING_ON));
		System.out.println(response);
	}
	
}
