package phd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {


	public void getWebPage(String url) throws IOException {
		Document doc = Jsoup.connect(url)
				  .data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .timeout(10000)
				  .get();
		System.out.println(doc.body().text());
		ArrayList<String> emails = emailParse(doc.body().text());
		ArrayList<String> numbers = phoneParse(doc.body().text());
			for(String email : emails) {
				System.out.println(email);
			}
			
			for(String number : numbers) {
				System.out.println(number);
			}
	}
	
	public static ArrayList<String> emailParse(String text) {
		Pattern p = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b",
			    Pattern.CASE_INSENSITIVE);
			Matcher matcher = p.matcher(text);
			ArrayList<String> emails = new ArrayList<>();
			while(matcher.find()) {
			  emails.add(matcher.group());
			}
			return emails;
	}
	
	public static ArrayList<String> phoneParse(String text) {
		Pattern p = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$",
			    Pattern.CASE_INSENSITIVE);
			Matcher matcher = p.matcher(text);
			ArrayList<String> emails = new ArrayList<>();
			while(matcher.find()) {
			  emails.add(matcher.group());
			}
			return emails;
	}

}
