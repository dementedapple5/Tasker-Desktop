package Model;


public class UserPojo {

	private String username;
	private String password;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserPojo() {
	}

	/**
	 *
	 * @param username
	 */
	public UserPojo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString(){

		return "User{" +
				"userName='" + username + '\'' +
				'}';
	} 

}




