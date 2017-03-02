package it.therickys93.facebookbot;

import java.math.BigInteger;

public class Entry {

	String id;
	BigInteger time;
	Messaging messaging;
	
	public String id() {
		return this.id;
	}
	
	public BigInteger time() {
		return this.time;
	}
	
	public Messaging messaging() {
		return this.messaging;
	}
	
	Entry() {
		
	}

}
