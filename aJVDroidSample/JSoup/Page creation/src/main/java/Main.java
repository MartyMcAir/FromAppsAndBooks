import org.jsoup.nodes.Document;

public class Main {
	public static void main(String[] args) {
		var doc = new Document("");
		var body = doc.appendElement("body");
		body.appendElement("h1").text("Hello, world!");
		body.appendElement("a").attr("href", "\"automatic escaping\"");
		System.out.println("Html built with Jsoup:");
		System.out.println(doc.html());
	}
}