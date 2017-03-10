package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import it.therickys93.facebookbot.request.SendSenderAction;
import it.therickys93.facebookbot.request.SenderAction;

public class SendChatActionTest {
	
	@Test
	public void testOne() {
		SendSenderAction chatAction = new SendSenderAction("USER_ID", SenderAction.TYPING_ON.toString());
		assertEquals("USER_ID", chatAction.id());
		assertEquals("typing_on", chatAction.action());
		assertEquals("{\"recipient\":{\"id\":\"USER_ID\"},\"sender_action\":\"typing_on\"}", chatAction.toJson().toString());
	}
		
	public void usage() throws IOException {
		FacebookBot bot = new FacebookBot("TOKEN");
		String response = bot.execute(new SendSenderAction("USER_ID", SenderAction.TYPING_ON.toString()));
		System.out.println(response);
	}
	
}
