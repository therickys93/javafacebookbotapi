package it.therickys93.facebookbot.model;

import java.math.BigInteger;

/**
 * entry object from Facebook
 * @author therickys93
 *
 */
public class Entry {

	String id;
	BigInteger time;
	Messaging messaging;
	
	/**
	 * return the id of the entry
	 * @return the id of the entry
	 */
	public String id() {
		return this.id;
	}
	
	/**
	 * return the timestamp of the entry
	 * @return the timestamp of the entry
	 */
	public BigInteger time() {
		return this.time;
	}
	
	/**
	 * return the messaging object of the entry
	 * @return the messaging object of the entry
	 */
	public Messaging messaging() {
		return this.messaging;
	}
	
	Entry() {
		
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Entry{id="+this.id+", time="+this.time+", messaging="+this.messaging+"}";
		return response;
	}

}
