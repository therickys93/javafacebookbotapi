package it.therickys93.facebookbot.model;

import java.math.BigInteger;

/**
 * messaging object from Facebook
 * @author therickys93
 *
 */
public class Messaging {

	String senderId;
	String recipientId;
	BigInteger timestamp;
	Message message;
	String postbackPayload;
	
	public String senderId() {
		return this.senderId;
	}
	
	Messaging() {
		
	}
	
	/**
	 * return the message object
	 * @return the message object
	 */
	public Message message() {
		return this.message;
	}

	/**
	 * return the recipient id
	 * @return the recipient id
	 */
	public String recipientId() {
		return this.recipientId;
	}

	/**
	 * return the timestamp
	 * @return the timestamp
	 */
	public BigInteger timestamp() {
		return this.timestamp;
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Messaging{sender="
				+ ""+this.senderId+", "
						+ "recipient="+this.recipientId+""
								+ ", timestamp="+this.timestamp+""
										+ ", postback_payload=" + this.postbackPayload
										+ ", message="+this.message+"}";
		return response;
	}

	/**
	 * return the payload of the postback
	 * @return
	 */
	public String postbackPayload() {
		return this.postbackPayload;
	}

}
