package phd;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	
	public static ArrayList<Users> getUsers() {
		ArrayList<Users> users = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert object to JSON string and save into a file directly
			Object obj = mapper.readValue(new File("/Users/renju/Developer/Web-Crawler/CSProfessors.json"), Object.class);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(obj);
			
			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			
			// Convert to JSONObject to traverse JSON array
			JSONObject jsonObj = new JSONObject(jsonInString);
			
			for(int i = 0; i < jsonObj.getJSONArray("list").length(); i++) {
				Users user = new Users();
				String name = jsonObj.getJSONArray("list").getJSONObject(i).get("Name").toString();
				String first_name = name.split(" ")[0];
				String last_name = name.split(" ")[name.split(" ").length - 1];
				
				String university = jsonObj.getJSONArray("list").getJSONObject(i).get("University").toString();
				String interests= jsonObj.getJSONArray("list").getJSONObject(i).get("Subfield").toString();
				String source1 = jsonObj.getJSONArray("list").getJSONObject(i).get("Sources1").toString();
				String doctorate = jsonObj.getJSONArray("list").getJSONObject(i).get("Doctorate").toString();
				String prof_rank = jsonObj.getJSONArray("list").getJSONObject(i).get("Rank").toString();
				
				user.setFirst_name(first_name);
				user.setLast_name(last_name);
				user.setField_of_interest(interests);
				user.setSource1(source1);
				user.setUniversity(university);
				user.setUser_type("Professor");
				user.setDoctorate(doctorate);
				user.setProf_rank(prof_rank);
				users.add(user);
			}
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public static String toJson(ArrayList<Users> users) throws JsonGenerationException, JsonMappingException, IOException {
		final OutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, users);
	    final byte[] data = ((ByteArrayOutputStream) out).toByteArray();
	    return new String(data);
	}
	
	public static String prettyPrint(String json) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		System.out.println(json);
		
		return json;
	}
}
