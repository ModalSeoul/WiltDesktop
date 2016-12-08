package fm.wilt.client.jwilt;

import fm.wilt.client.jwilt.Http;

import java.io.IOException;

import org.json.simple.*;


public class Api {
	
	public String apiToken;
	protected String format;
	protected Http http;
	
	public Api() {
		this.http = new Http("https://wilt.fm/api/");
	}
	
	/**
	 * 
	 * @param nick
	 * @return
	 */
	public JSONObject getMember(String nick) {
		return http.apiGet(String.format("members/%s/by_nick/", nick));
	}
	
	public JSONObject getLeaderboard() {
		return http.apiGet("members/most_scrobbles/?leaderboard=true");
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		String payload = String.format("username=%s&password=%s", username, password);
		try {
			JSONObject tokenResponse = http.post("api-token-auth/", payload, apiToken);
			this.apiToken = "Token " + (String) tokenResponse.get("token");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param artist
	 * @param song
	 * @param album
	 */
	public JSONObject postScrobble(String artist, String song, String... album) {
		String payload = String.format("song=%s&artist=%s", artist, song);
		if (album != null)
			payload.concat("&album=" + album);

		try {
			return http.post("scrobbles/", payload, apiToken);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isAuthed() {
		if (apiToken.length() > 5)
			return true;
		else
			return false;
	}

}