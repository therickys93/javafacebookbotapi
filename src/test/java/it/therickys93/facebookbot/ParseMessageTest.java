package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import it.therickys93.facebookbot.model.Entry;
import it.therickys93.facebookbot.model.FacebookBotParser;
import it.therickys93.facebookbot.model.Message;
import it.therickys93.facebookbot.model.Messaging;
import it.therickys93.facebookbot.model.Payload;

public class ParseMessageTest {
	
	@Test
	public void testMessage() throws FileNotFoundException {
		Payload message = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/request.txt"));
		assertEquals("page", message.object());
		assertEquals("PAGE_ID", message.entry().id());
		assertEquals("1458692752478", message.entry().time().toString());
		assertEquals("USER_ID", message.entry().messaging().senderId());
		assertEquals("PAGE_ID", message.entry().messaging().recipientId());
		assertEquals("1458692752478", message.entry().messaging().timestamp().toString());
		assertEquals("mid.1457764197618:41d102a3e1ae206a38", message.entry().messaging().message().id());
		assertEquals(73, message.entry().messaging().message().seq());
		assertEquals("hello, world!", message.entry().messaging().message().text());
		assertEquals("DEVELOPER_DEFINED_PAYLOAD", message.entry().messaging().message().quickReplyText());
		assertTrue(message.ok());
	}
	
	@Test
	public void testNoQuickReply() throws FileNotFoundException {
		Payload message = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/request2.txt"));
		assertTrue(message.ok());
		assertNull(message.entry().messaging().message().quickReplyText());
	}
	
	@Test
	public void testNoTextMessage() throws FileNotFoundException {
		Payload payload = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/notext.txt"));
		assertFalse(payload.ok());
	}
	
	@Test
	public void testIncreaseCodeCoverage() {
		FacebookBotParser utils = new FacebookBotParser();
		utils.toString();
	}
	
	@Test
	public void testMessageToString() throws FileNotFoundException{
		Payload payload = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/request.txt"));
		Message message = payload.entry().messaging().message();
		assertEquals(messageToStringOutput(), message.toString());
	}
	
	@Test
	public void testMessaggingToString() throws FileNotFoundException {
		Payload payload = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/request.txt"));
		Messaging messaging = payload.entry().messaging();
		assertEquals(messagingToStringOutput(), messaging.toString());
	}
	
	@Test
	public void testEntryToString() throws FileNotFoundException {
		Payload payload = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/request.txt"));
		Entry entry = payload.entry();
		assertEquals(entryToStringOutput(), entry.toString());
	}
	
	@Test
	public void testPayloadToString() throws FileNotFoundException {
		Payload payload = FacebookBotParser.parsePayload(getContentOfFile("src/test/resources/request.txt"));
		assertEquals(payloadToStringOutput(), payload.toString());
	}
	
	private String payloadToStringOutput() {
		return "Payload{object=page, entry="
				+ "Entry{id=PAGE_ID, time=1458692752478, messaging="
				+ "Messaging{sender=USER_ID, recipient=PAGE_ID, timestamp=1458692752478, message="
				+ "Message{id=mid.1457764197618:41d102a3e1ae206a38, seq=73, text=hello, world!, quick_reply=DEVELOPER_DEFINED_PAYLOAD}}}}";
	}
	
	private String entryToStringOutput() {
		return "Entry{id=PAGE_ID, time=1458692752478, messaging="
				+ "Messaging{sender=USER_ID, recipient=PAGE_ID, timestamp=1458692752478, message="
				+ "Message{id=mid.1457764197618:41d102a3e1ae206a38, seq=73, text=hello, world!, quick_reply=DEVELOPER_DEFINED_PAYLOAD}}}";
	}
	
	private String messagingToStringOutput() {
		return "Messaging{sender=USER_ID, recipient=PAGE_ID, timestamp=1458692752478, message="
				+ "Message{id=mid.1457764197618:41d102a3e1ae206a38, seq=73, text=hello, world!, quick_reply=DEVELOPER_DEFINED_PAYLOAD}}";
	}
	
	private String messageToStringOutput() {
		return "Message{id=mid.1457764197618:41d102a3e1ae206a38, seq=73, text=hello, world!, quick_reply=DEVELOPER_DEFINED_PAYLOAD}";
	}
	
	private String getContentOfFile(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}
	
}
