package by.epam.tasks.task1.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userType;
	private final String login;
	private final String passwordHash;
	private String email;

	public User(int userType, String login, String passwordHash, String email) {
		super();
		this.userType = userType;
		this.login = login;
		this.passwordHash = passwordHash;
		this.email = email;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getLogin() {
		return login;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
		result = prime * result + userType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (passwordHash == null) {
			if (other.passwordHash != null)
				return false;
		} else if (!passwordHash.equals(other.passwordHash))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [userType=" + ((userType == 1) ? "Admin" : "User") + ", login="
				+ login + ", email=" + email + "]";
	}

}
