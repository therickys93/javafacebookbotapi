package it.therickys93.facebookbot.model;

/**
 * message object from Facebook
 * @author therickys93
 *
 */
public class Message {

	String id;
	int seq;
	String text;
	String quickReplyText;
	
	Message() {
		
	}

	/**
	 * return the id of the message
	 * @return the id of the message
	 */
	public String id() {
		return this.id;
	}

	/**
	 * return the seq of the message
	 * @return the seq of the message
	 */
	public int seq() {
		return this.seq;
	}

	/**
	 * return the text of the message
	 * @return the text of the message
	 */
	public String text() {
		return this.text;
	}

	/**
	 * return the quick reply text as string
	 * @return the quick reply text as string
	 */
	public String quickReplyText() {
		return this.quickReplyText;
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Message{id="+this.id+", seq="+this.seq+", text="+this.text+", quick_reply="+this.quickReplyText+"}";
		return response;
	}
	
}
