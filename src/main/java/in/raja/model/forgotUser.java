package in.raja.model;

public class forgotUser {

	private long  phoneNumber;
	private String password1;
	private String password2;

	public  forgotUser(long phoneNumber, String password1, String password2) {
		this.phoneNumber = phoneNumber;
		this.password1 = password1;
		this.password2 = password2;

		
		
	}
	
	

	public long getPhoneNumber() {
		return phoneNumber;
	}



	public String getPassword1() {
		return password1;
	}

	
	public String getPassword2() {
		return password2;
	}

	

	@Override
	public String toString() {
		return "forgotUser [phoneNumber=" + phoneNumber + ", password1=" + password1 + ", password2=" + password2 + "]";
	}

	
	
}
