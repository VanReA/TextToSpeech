package dataBase;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.text.html.parser.Parser;

import org.apache.commons.io.IOUtils;

public class SearchIntoWeb {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.imdb.com/title/tt1905041/?ref_=nv_sr_3");
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
//		System.out.println(body);
		
//		System.out.println(body.indexOf("itemprop=\"genre\""));
		System.out.println(body.subSequence(body.indexOf("itemprop=\"genre\""), body.indexOf("itemprop=\"genre\"")+300));
		
	}

}
