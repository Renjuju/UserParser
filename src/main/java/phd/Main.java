package phd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		Crawler crawler = new Crawler();
		
	    ArrayList<Users> users = JsonParser.getUsers();
		
	    ArrayList<Users> testUsers = new ArrayList<>();
		int counter = 0;
		for(Users user : users) {
			counter++;
			System.out.println("-----------------------------");
			System.out.println(user.getFirst_name() + " " + user.getLast_name());
			System.out.println("Field of interest: " + user.getField_of_interest());
			try {
				Users crawledUserData = crawler.getWebPage(user.getSource1());
				user.setBio(crawledUserData.getBio());
				user.setNumber(crawledUserData.getNumber());
				user.setEmail(crawledUserData.getEmail());
				user.setImages(crawledUserData.getImages());
			} catch(Exception e) {
				
			}
			testUsers.add(user);
			if(counter == 10) {
				break;
			}
			
		}
		
		String jsonArray = JsonParser.toJson(testUsers);
		System.out.println(jsonArray);
		PrintWriter out = new PrintWriter("csProfData.json");
		out.println(jsonArray);
		out.close();
	}
}
