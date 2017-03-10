package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.facebookbot.request.QuickReply;

public class QuickReplyTest {

	@Test
	public void testOne() {
		QuickReply quickReply = new QuickReply(QuickReply.TEXT, "title", "payload");
		assertEquals("text", quickReply.type());
		assertEquals("title", quickReply.title());
		assertEquals("payload", quickReply.payload());
		assertEquals("{\"content_type\":\"text\",\"title\":\"title\",\"payload\":\"payload\"}", quickReply.toJson().toString());
	}
	
}
