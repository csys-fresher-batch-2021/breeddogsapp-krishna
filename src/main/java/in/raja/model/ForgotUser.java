package in.raja.model;

public class ForgotUser {

	private long phoneNumber;
	private String password;
	private String confirmPassword;

	public ForgotUser(long phoneNumber, String password, String confirmPassword) {
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;

	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Override
	public String toString() {
		return "forgotUser [phoneNumber=" + phoneNumber + ", password1=" + password + ", password2=" + confirmPassword
				+ "]";
	}

}
