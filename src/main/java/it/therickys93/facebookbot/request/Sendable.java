package it.therickys93.facebookbot.request;

import com.google.gson.JsonObject;

/**
 * interface that send something to Facebook
 * @author therickys93
 *
 */
public interface Sendable {
	
	/**
	 * return the endpoint of the request
	 * @return the endpoint
	 */
	public String endpoint();
	/**
	 * return the json object representation of the request
	 * @return
	 */
	public JsonObject toJson();

}