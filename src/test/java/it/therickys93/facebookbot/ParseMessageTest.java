package it.therickys93.facebookbot;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ParseMessageTest {
	
	@Test
	public void testMessage() throws FileNotFoundException {
		Payload message = FacebookBotUtils.parsePayload(getContentOfFileContainSimpleMessage());
		assertEquals("page", message.object());
		assertEquals("PAGE_ID", message.entry().id());
		assertEquals("1458692752478", message.entry().time().toString());
		assertEquals("USER_ID", message.entry().messaging().senderId());
		assertEquals("PAGE_ID", message.entry().messaging().recipientId());
		assertEquals("1458692752478", message.entry().messaging().timestamp().toString());
		assertEquals("mid.1457764197618:41d102a3e1ae206a38", message.entry().messaging().message().id());
		assertEquals(73, message.entry().messaging().message().seq());
		assertEquals("hello, world!", message.entry().messaging().message().text());
	}
	
	private String getContentOfFileContainSimpleMessage() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/test/resources/request.txt"));
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}
	
}
