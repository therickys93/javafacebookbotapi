package it.therickys93.facebookbot.model;

import java.math.BigInteger;

public class Messaging {

	String senderId;
	String recipientId;
	BigInteger timestamp;
	Message message;
	
	public String senderId() {
		return this.senderId;
	}
	
	Messaging() {
		
	}
	
	public Message message() {
		return this.message;
	}

	public String recipientId() {
		return this.recipientId;
	}

	public BigInteger timestamp() {
		return this.timestamp;
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Messaging{sender="+this.senderId+", recipient="+this.recipientId+", timestamp="+this.timestamp+", message="+this.message.toString()+"}";
		return response;
	}

}
