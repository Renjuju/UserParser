package phd;

public class Users {
	
	private String email;
	private String first_name;
	private String last_name;
	private String bio;
	private String field_of_interest;
	private String user_type;
	private String source1;
	
	public void setSource1(String source1) {
		this.source1 = source1;
	}
	
	public String getSource1() {
		return this.source1;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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
