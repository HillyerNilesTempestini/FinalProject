/**
 * 
 * @author Sam Tempestini
 *
 */
public class Film {
	private String year;
	private String title;
	private String role;
	private String notes;
	private String ref;
	
	public Film() 
	{
		this.year = "";
		this.title = "";
		this.role = "";
		this.notes = "";
		this.ref = "";
	}
	
	public Film(String yr, String tt, String rl,String nt, String rf)
	{
		setYear(yr);
		setTitle(tt);
		setRole(rl);
		setNotes(nt);
		setRef(rf);
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	@Override
	public String toString() {
		return String.format("%4s %-45s %-30s %-30s %4s,", this.year, this.title, this.role, this.notes, this.ref);
	}
}
