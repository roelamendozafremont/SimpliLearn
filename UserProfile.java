package package1;

import java.io.Serializable;

public class UserProfile implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;

	public UserProfile() {
// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", userName="
				+ userName + ", password=" + password + "]";
	}

	public UserProfile(String firstName, String lastName, String emailId, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
