package it.therickys93.facebookbot;

public class Message {

	String id;
	int seq;
	String text;
	
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
	
}
