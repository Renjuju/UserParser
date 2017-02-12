package phd;

import java.util.ArrayList;

public class Users {
	
	private ArrayList<String> email;
	private ArrayList<String> number;
	private ArrayList<String> images;

	private String first_name;
	private String last_name;
	private String bio;
	private String field_of_interest;
	private String user_type;
	private String source1;
	private String university;
	private String doctorate;
	private String prof_rank;
	
	
	public String getProf_rank() {
		return prof_rank;
	}

	public void setProf_rank(String prof_rank) {
		this.prof_rank = prof_rank;
	}

	public String getDoctorate() {
		return doctorate;
	}

	public void setDoctorate(String doctorate) {
		this.doctorate = doctorate;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public ArrayList<String> getNumber() {
		return number;
	}

	public void setNumber(ArrayList<String> number) {
		this.number = number;
	}
	
	public void setUniversity(String university) {
		this.university = university;
	}
	
	public String getUniversity() {
		return this.university;
	}
	
	public void setSource1(String source1) {
		this.source1 = source1;
	}
	
	public String getSource1() {
		return this.source1;
	}
	
	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getField_of_interest() {
		return field_of_interest;
	}

	public void setField_of_interest(String field_of_interest) {
		this.field_of_interest = field_of_interest;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
}
