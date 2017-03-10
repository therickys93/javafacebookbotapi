package it.therickys93.facebookbot;

public class Message {

	String id;
	int seq;
	String text;
	String quickReplyText;
	
	Message() {
		
	}

	public String id() {
		return this.id;
	}

	public int seq() {
		return this.seq;
	}

	public String text() {
		return this.text;
	}

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
