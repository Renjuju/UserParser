package phd;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		Crawler crawler = new Crawler();
		
		
		ArrayList<Users> users = JsonParser.getUsers();
		for(Users user : users) {
			System.out.println("-----------------------------");
			System.out.println(user.getFirst_name() + " " + user.getLast_name());
			System.out.println("Field of interest: " + user.getField_of_interest());
			try {
				crawler.getWebPage(user.getSource1());
			} catch(Exception e) {
				
			}
		}
		
	}
}
