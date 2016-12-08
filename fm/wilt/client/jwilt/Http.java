package fm.wilt.client.jwilt;

import java.net.*;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;


public class Http {
	
	public JSONParser parser = new JSONParser();
	protected HttpURLConnection connection;
	protected String APIUrl;
	
	public Http(String APIUrl) {
		this.APIUrl = APIUrl;
	}
	
	public JSONObject apiGet(String endpoint) {
		try {
			String response = get(endpoint, "?format=json");
			JSONObject responseObj = new JSONObject();
			responseObj = (JSONObject) parser.parse(response);
			return responseObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param endPoint
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String get(String endPoint, String format) throws Exception {
		URL url = new URL(String.format("%s%s%s", APIUrl, endPoint, format));
		URLConnection wilt = url.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(wilt.getInputStream()));
		String inputLine = in.readLine();
		in.close();
		return inputLine;
	}
	
	public JSONObject post(String endpoint, String payload, String token) throws IOException {
		URLConnection wilt = getOpenedConnection(endpoint, token);
		wilt.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(wilt.getOutputStream());
		
		writer.write(payload);
		writer.flush();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(wilt.getInputStream()));
		try {
			return (JSONObject) parser.parse(in.readLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		in.close();
		return null;
	}
	
	private URLConnection getOpenedConnection(String endpoint, String token) {
		try {
			URL url = new URL(APIUrl + endpoint);
			URLConnection wilt = url.openConnection();
			wilt.setRequestProperty("Authorization", token);
			return wilt;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}