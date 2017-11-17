package Model;


public class User {

	private String username;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public User() {
	}

	/**
	 *
	 * @param username
	 */
	public User(String username) {
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





