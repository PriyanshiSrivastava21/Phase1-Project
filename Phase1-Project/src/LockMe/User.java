package LockMe;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}

	

	

	public String getUsername() {
		System.out.println("User name:"+getUsername());
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [ username=" + username +  ", password=" + password
				+ "]";
		//return username;
	}
	
	
 
}
