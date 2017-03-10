package it.therickys93.facebookbot.request;

public enum SenderAction {

	TYPING_ON("typing_on"),
	TYPING_OFF("typing_off"),
	MARK_SEEN("mark_seen");
	
	private final String action;
	
	private SenderAction(String action){
		this.action = action;
	}
	
	@Override
	public String toString() {
		return this.action;
	}

}
