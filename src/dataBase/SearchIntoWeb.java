package dataBase;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;


public class SearchIntoWeb {

	private String[] allGenres = { "Action", "Adventure", "Animation",
		    "Biography", "Comedy", "Crime", "Documentary", "Drama",
		    "Family", "Fantasy", "Film-Noir", "History", "Horror",
		    "Music", "Musical", "Mystery", "Romance", "Sci-Fi",
		    "Short", "Sport", "Thriller", "War", "Western"} ;
	
	public List<String> movieGenres(String movieURL){
		
		List<String> listOfGenres = new ArrayList<>();
		
		try {
			URL url = new URL(movieURL);
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);
			String restHTML = (String) body.subSequence(body.indexOf("itemprop=\"genre\""), body.length());
			String finalHTML4Search = "";
			finalHTML4Search = (String) restHTML.subSequence(0, restHTML.indexOf("</div>"));
			
			for(String genre : getAllGenres()){
				if(finalHTML4Search.contains(genre))
					listOfGenres.add(genre);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfGenres;
	}
	

	public String[] getAllGenres() {
		return allGenres;
	}

	public void setAllGenres(String[] allGenres) {
		this.allGenres = allGenres;
	}

}
