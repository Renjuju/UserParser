package phd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

public class Crawler {


	public Users getWebPage(String url) throws IOException {
		Document doc = Jsoup.connect(url)
				  .data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .timeout(10000)
				  .get();
		Users user = new Users();
		
		ArrayList<String> images = new ArrayList<String>();
 		ArrayList<String> emails = emailParse(doc.body().text());
		ArrayList<String> numbers = phoneParse(doc.body().text());
		
		for (Element e : doc.select("img")) {
		    images.add(e.attr("src"));
		}
		
		user.setEmail(emails);
		user.setNumber(numbers);
		user.setBio(doc.body().text());
		user.setImages(images);
			for(String email : emails) {
				System.out.println(email);
			}
			
			for(String number : numbers) {
				System.out.println(number);
			}
		return user;
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
	    Iterator<PhoneNumberMatch> existsPhone=PhoneNumberUtil.getInstance().findNumbers(text, "US").iterator();
	    ArrayList<String> numbers = new ArrayList<>();
	    while (existsPhone.hasNext()){
	    	String[] number = existsPhone.next().number().toString().split(" ");
	        numbers.add(number[number.length - 1]);
	    }
	    return numbers;
	}

}
