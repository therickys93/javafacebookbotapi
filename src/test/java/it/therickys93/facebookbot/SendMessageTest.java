package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import org.junit.Test;

public class SendMessageTest {
	
	@Test
	public void testOne() {
		SendMessage sendMessage = new SendMessage("USER_ID", "hello, world!");
		assertEquals("USER_ID", sendMessage.id());
		assertEquals("hello, world!", sendMessage.text());
		assertEquals("{\"recipient\":{\"id\":\"USER_ID\"},\"message\":{\"text\":\"hello, world!\"}}", sendMessage.toJson());
	}
	
	@Test
	public void testTwo() {
		FacebookBot bot = new FacebookBot("BOT_TOKEN");
		assertEquals("BOT_TOKEN", bot.token());
		assertEquals("https://graph.facebook.com/v2.6/me/messages?access_token=", FacebookBot.API_URL);
		assertEquals("https://graph.facebook.com/v2.6/me/messages?access_token=BOT_TOKEN", bot.endpoint);
	}	
}
