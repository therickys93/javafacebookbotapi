package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

public interface Sendable {
	
	public String endpoint();
	public JsonObject toJson();

}