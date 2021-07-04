package in.raja.model;

public class UserDetails {
	private String userName;
	private String userMail;
	private String password;
	private String confirmPassword;
	private String city;
	private long phoneNumber;

	public UserDetails(String userName, String userMail, String password, String confirmPassword, long phoneNumber,
			String city) {
		this.userName = userName;
		this.userMail = userMail;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public String getpassword1() {
		return password;
	}

	public long getphoneNumber() {
		return phoneNumber;
	}

	public String getcity() {
		return city;
	}

	@Override
	public String toString() {
		return "UserDetails [username=" + userName + ", userMail=" + userMail + ", password1=" + password
				+ ", password2=" + confirmPassword + ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
	}

}
