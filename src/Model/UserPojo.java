package Model;


public class UserPojo {

	private String username;

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
	public UserPojo(String username) {
		super();
		this.username = username;
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




