import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("https://example.com").get();
		Elements paragraphs = doc.select("p");
		System.out.println("Paragraphs: " + paragraphs);
		System.out.println("Links:");
		Elements links = doc.select("a");
		for (Element e : links) {
			System.out.println("Link: " + e);
			System.out.println("Href: " + e.attr("href"));
		}
	}
}