package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ParseMessageTest {
	
	@Test
	public void testMessage() throws FileNotFoundException {
		Payload message = FacebookBotUtils.parsePayload(getContentOfFile("src/test/resources/request.txt"));
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
	}
	
	@Test
	public void testNoQuickReply() throws FileNotFoundException {
		Payload message = FacebookBotUtils.parsePayload(getContentOfFile("src/test/resources/request2.txt"));
		assertNull(message.entry().messaging().message().quickReplyText());
	}
	
	private String getContentOfFile(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}
	
}
