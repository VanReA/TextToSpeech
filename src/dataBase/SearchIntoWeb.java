package dataBase;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.text.html.parser.Parser;

import org.apache.commons.io.IOUtils;

public class SearchIntoWeb {

	public static void main(String[] args) throws IOException {

		String[] allGenres = { "Action", "Adventure", "Animation",
			    "Biography", "Comedy", "Crime", "Documentary", "Drama",
			    "Family", "Fantasy", "Film-Noir", "History", "Horror",
			    "Music", "Musical", "Mystery", "Romance", "Sci-Fi",
			    "Short", "Sport", "Thriller", "War", "Western"} ;

//		URL url = new URL("http://www.imdb.com/title/tt1905041/?ref_=nv_sr_3");
		URL url = new URL("http://www.imdb.com/title/tt0068646/?ref_=chttp_tt_2");
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		String restHTML = (String) body.subSequence(body.indexOf("itemprop=\"genre\""), body.length());
		String finalHTML4Search = "";
		finalHTML4Search = (String) restHTML.subSequence(0, restHTML.indexOf("</div>"));
		
		for(String genre : allGenres){
			if(finalHTML4Search.contains(genre))
				System.out.println(genre);
		}
//		System.out.println(finalHTML4Search);
		
	}

}
