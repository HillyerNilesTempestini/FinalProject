import java.util.Scanner;
import java.net.URL;
public class ScreenScraper {
	public static void ScrapeScreen(String[] args) {
		System.out.print("Enter the url: ");
		Scanner sc = new Scanner(System.in);
		String addr = sc.nextLine();
		try {
			URL link = new URL(addr);
			Scanner usc = new Scanner(link.openStream());
			while (usc.hasNextLine()) {
				System.out.println(usc.nextLine());
			}
			usc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
