package it.therickys93.facebookbot;

import static org.junit.Assert.*;

import org.junit.Test;
import it.therickys93.facebookbot.request.QuickReplyType;
import it.therickys93.facebookbot.request.SenderAction;

public class EnumsTest {

	@Test
	public void testOne() {
		assertEquals("text", QuickReplyType.TEXT.toString());
	}
	
	@Test
	public void testTwo() {
		assertEquals("typing_on", SenderAction.TYPING_ON.toString());
		assertEquals("typing_off", SenderAction.TYPING_OFF.toString());
		assertEquals("mark_seen", SenderAction.MARK_SEEN.toString());
	}
	
	 @Test
	 public void improveCodeCoverageSenderAction() {
		 SenderAction[] actions = SenderAction.values();
		 assertEquals(3, actions.length);
		 SenderAction action = SenderAction.valueOf("MARK_SEEN");
		 assertEquals("mark_seen", action.toString());
	 }
	 
	 @Test
	 public void improveCodeCoverageQuickReplyType() {
		 QuickReplyType[] types = QuickReplyType.values();
		 assertEquals(1, types.length);
		 QuickReplyType type = QuickReplyType.valueOf("TEXT");
		 assertEquals("text", type.toString());
	 }
	
}
