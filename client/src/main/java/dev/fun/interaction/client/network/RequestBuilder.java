package dev.fun.interaction.client.network;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
	
	private static final String GET = "GET";
	private static final String PROTOCOL = "HTTP/1.1";
	private static final String DELIMETER = "\n";
	private static final String USER_AGENT = "User-Agent: hello_world";
	
	private final Map<String, String> headers;
	private final Map<String, String> params;
	private final String url;
	
	public RequestBuilder(String url) {
		this.headers = new HashMap<>();
		this.params = new HashMap<>();
		this.url = url;
	}
	
	public RequestBuilder addHeader(String header, String value) {
		headers.put(header, value);
		return this;
	}
	
	public RequestBuilder addParams(String param, String value) {
		params.put(param, value);
		return this;
	}
	
	public String buildGet() {
		StringBuilder sb = new StringBuilder(GET);
		sb.append(" ")
			.append("http://")
			.append(url);
		if (!params.isEmpty()) {
			sb.append("?");
			for(Map.Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey())
					.append("=")
					.append(entry.getValue())
					.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append(" ")
			.append(PROTOCOL)
			.append(DELIMETER)
			.append(USER_AGENT)
			.append(DELIMETER);
		if (!headers.isEmpty()) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				sb.append(entry.getKey())
					.append(": ")
					.append(entry.getValue())
					.append(DELIMETER);
			}
		}
		return sb.toString();
	}
	
}
