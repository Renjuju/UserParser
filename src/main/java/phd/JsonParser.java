package phd;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	
	public static void main(String[] args) {
		JsonParser obj = new JsonParser();
		obj.run();
	}
	
	private void run() {
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
				System.out.println(jsonObj.getJSONArray("list").getJSONObject(i).get("Name"));
			}
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
