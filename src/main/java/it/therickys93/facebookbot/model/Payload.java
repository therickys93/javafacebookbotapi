package it.therickys93.facebookbot.model;

/**
 * payload from Facebook
 * @author therickys93
 *
 */
public class Payload {

	String object;
	Entry entry;
	boolean ok;
	
	/**
	 * return the object that should be always "page"
	 * @return the object
	 */
	public String object() {
		return this.object;
	}

	Payload() {
		
	}

	/**
	 * return the entry object of the payload
	 * @return the entry object
	 */
	public Entry entry() {
		return this.entry;
	}

	/**
	 * Not able to Parse the message because I receive something that, for now, I cannot understand
	 * @return true if able, false not
	 */
	public boolean ok() {
		return this.ok;
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Payload{object="+this.object+", entry="+this.entry+"}";
		return response;
	}
	
}
