package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.facebookbot.request.QuickReply;
import it.therickys93.facebookbot.request.QuickReplyType;

public class QuickReplyTest {

	@Test
	public void testOne() {
		QuickReply quickReply = new QuickReply(QuickReplyType.TEXT.toString(), "title", "payload");
		assertEquals("text", quickReply.type());
		assertEquals("title", quickReply.title());
		assertEquals("payload", quickReply.payload());
		assertEquals("{\"content_type\":\"text\",\"title\":\"title\",\"payload\":\"payload\"}", quickReply.toJson().toString());
	}
	
}
