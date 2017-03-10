package it.therickys93.facebookbot.request;

public enum QuickReplyType {

	TEXT("text");
	
	private final String type;
	
	private QuickReplyType(String type){
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
