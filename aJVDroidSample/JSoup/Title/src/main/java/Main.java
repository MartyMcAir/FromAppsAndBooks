import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("https://example.com").get();
		System.out.println("Title: " + doc.title());
	}
}