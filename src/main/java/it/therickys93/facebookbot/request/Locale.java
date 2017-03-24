package it.therickys93.facebookbot.request;

/**
 * Locale enum 
 * @author Ricky
 *
 */
public enum Locale {
	
	DEFAULT("default"),
	ENGLISH("en_US"),
	ITALIAN("it_IT");
	
	private final String type;
	
	private Locale(String type){
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
	
}
