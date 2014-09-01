package dataBase;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
 
public class GoogleSearchEngine {
 
	private String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	private String query ;
	private String charset = "UTF-8";
	
	public String getMovieURL(String movieTitle){	
		String movieURL = "";

		try {
			setQuery(movieTitle + " site:www.imdb.com");
			
			URL url = new URL(address + URLEncoder.encode(query, charset));
			
			Reader reader = new InputStreamReader(url.openStream(), charset);
			GoogleSearchResults results = new Gson().fromJson(reader, GoogleSearchResults.class);
	 
//			int total = results.getResponseData().getResults().size();
			movieURL = results.getResponseData().getResults().get(0).getUrl();
//			for(int i=0; i<=total-1; i++){
//				System.out.println("Title: " + results.getResponseData().getResults().get(i).getTitle());
//				System.out.println("URL: " + results.getResponseData().getResults().get(i).getUrl() + "\n");
//	 
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movieURL; 
		
	}
	
	
	
	
	//Getters and Setters
	public static void main(String[] args) {
 
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
}

