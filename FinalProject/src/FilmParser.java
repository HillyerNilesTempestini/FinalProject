import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import org.jsoup.*;
import java.util.*;

/**
 * 
 * @author Sam Tempestini
 *
 */

public class FilmParser {
	
	public static void parseFilms() {
		Document doc;
		String test;
		int val;
		int length;
		
		ArrayList<Film> movies = new ArrayList<Film>();
		Film movie = new Film();
		
		try {
			doc = Jsoup.connect("https://en.wikipedia.org/wiki/Robert_Downey_Jr._filmography").get();
		
		   String title = doc.title();
		   System.out.println("Title: " + title);
		   
		   for (Element table : doc.select("table")) {
		        for (Element row : table.select("tr")) {
		        	Elements th= row.select("th");
		            Elements tds = row.select("td");
		           
		            if (tds.size() > 0) {
		               
		                test = tds.get(3).text();
		                length = test.length();
		                if (length < 4)
		                	test = test.substring(1,2);
		                else if (length > 3)
		                	test = test.substring(1,3);
			            
			            System.out.println(th.get(0).text() + ":" + tds.get(0).text() + ":" + tds.get(1).text() 
		                		+ ":" + tds.get(2).text() + ":" + test);
			            

			            movies.add(new Film(th.get(0).text(),tds.get(0).text(),tds.get(1).text(),tds.get(2).text(),test));
		            }
		        }
		        break;
		    }
		   System.out.println();
		   System.out.println("***********************************************************************************************************************************");
		   System.out.println();
		   for (Film m: movies)
		   {
			   System.out.println(m);
		   }
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}