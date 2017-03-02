package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SendChatActionTest {

	@Test
	public void testOne() {
		assertEquals("typing_on", ChatAction.TYPING_ON);
		assertEquals("typing_off", ChatAction.TYPING_OFF);
		assertEquals("mark_seen", ChatAction.MARK_SEEN);
	}
	
	@Test
	public void testTwo() {
		SendChatAction chatAction = new SendChatAction("USER_ID", ChatAction.TYPING_ON);
		assertEquals("USER_ID", chatAction.id());
		assertEquals("typing_on", chatAction.action());
		assertEquals("{\"recipient\":{\"id\":\"USER_ID\"},\"sender_action\":\"typing_on\"}", chatAction.toJson());
	}
	
	public void usage() throws IOException {
		FacebookBot bot = new FacebookBot("TOKEN");
		String response = bot.execute(new SendChatAction("USER_ID", ChatAction.TYPING_ON));
		System.out.println(response);
	}
	
}
