package it.therickys93.facebookbot;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.therickys93.facebookbot.request.QuickReply;
import it.therickys93.facebookbot.request.QuickReplyType;
import it.therickys93.facebookbot.request.SendMessage;

public class SendMessageTest {
	
	@Test
	public void testOne() {
		SendMessage sendMessage = new SendMessage("USER_ID", "hello, world!");
		assertEquals("USER_ID", sendMessage.id());
		assertEquals("hello, world!", sendMessage.text());
		assertEquals("{\"recipient\":{\"id\":\"USER_ID\"},\"message\":{\"text\":\"hello, world!\"}}", sendMessage.toJson().toString());
	}
	
	@Test
	public void testTwo() {
		FacebookBot bot = new FacebookBot("BOT_TOKEN");
		assertEquals("BOT_TOKEN", bot.token());
	}
	
	@Test
	public void testThree() {
		List<QuickReply> replies = new ArrayList<QuickReply>();
		replies.add(new QuickReply(QuickReplyType.TEXT.toString(), "hello", "ciao"));
		SendMessage message = new SendMessage("USER_ID", "hello my friend");
		message.addQuickReplies(replies);
		assertEquals("{\"recipient\":{\"id\":\"USER_ID\"},\"message\":{\"text\":\"hello my friend\",\"quick_replies\":[{\"content_type\":\"text\",\"title\":\"hello\",\"payload\":\"ciao\"}]}}", message.toJson().toString());
	}
	
	public void usage() throws IOException {
		FacebookBot bot = new FacebookBot("TOKEN");
		String response = bot.execute(new SendMessage("USER_ID", "hello my friend"));
		System.out.println(response);
	}
}
