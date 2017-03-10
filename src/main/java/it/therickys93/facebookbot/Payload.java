package it.therickys93.facebookbot;

public class Payload {

	String object;
	Entry entry;
	boolean ok;
	
	public String object() {
		return this.object;
	}

	Payload() {
		
	}

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
		response += "Payload{object="+this.object+", entry="+this.entry.toString()+"}";
		return response;
	}
	
}
