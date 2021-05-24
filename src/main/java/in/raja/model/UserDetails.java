package in.raja.model;

public class UserDetails {
	private String username;
	private String userMail;
	private String password1;

	private long phoneNumber;

	public UserDetails(String username, String userMail, String password1, long phoneNumber) {
		this.username = username;
		this.userMail = userMail;
		this.password1 = password1;

		this.phoneNumber = phoneNumber;

	}

	public String getName() {
		return username;
	}

	public String getUserMail() {
		return userMail;
	}

	public String getpassword1() {
		return password1;
	}

	public long getphoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", userMail=" + userMail + ", password1=" + password1
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
