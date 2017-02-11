package phd;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Crawler crawler = new Crawler();
		crawler.getWebPage("http://www.cci.drexel.edu/SeniorDesign/2016_2017/AdvisorConnect/AdvisorConnect.html");
	}
}
