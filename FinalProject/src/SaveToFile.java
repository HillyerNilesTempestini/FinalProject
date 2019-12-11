import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * 
 * @author Sam Tempestini
 *
 */
public class SaveToFile {
	  public static boolean writeTextFile(ArrayList<Film> movies, String filename) {
	        try {
	            PrintWriter pw = new PrintWriter(new BufferedWriter(
	                new FileWriter(new File(filename))));
	            for (Film m: movies) {
	                pw.println(m);
	            }
	            pw.close();
	            return true;
	        } catch (Exception ex) {
	            return false;
	        }
	  }
	  
	
		@SuppressWarnings("unchecked")
		public static boolean writeJSONFile(ArrayList<Film> movies, String fname) {
	        try {
	            PrintWriter pw = new PrintWriter(new BufferedWriter(
	                    new FileWriter(fname)));
	            JSONArray array = new JSONArray();
	            JSONObject obj;
	            
				for (Film m: movies) {
	                obj = new JSONObject();
	                obj.put("year", m.getYear());
	                obj.put("title", m.getTitle());
	                obj.put("role", m.getRole());
	                obj.put("notes", m.getNotes());
	                obj.put("reference", m.getRef());
	
	                array.add(obj);
				}
		        JSONObject movieList = new JSONObject();
		        movieList.put("movie", array);
		        pw.println(movieList.toJSONString());
		        pw.close();
		        return true;
		    } catch (Exception ex) {
		        return false;
		    }
	}
}

