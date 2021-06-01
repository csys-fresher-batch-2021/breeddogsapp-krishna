package in.raja.model;

public class UserDetails {
	private String username;
	private String userMail;
	private  String password1;
	private String password2;
	private String city;
	private  long phoneNumber;

	public UserDetails(String username, String userMail, String password1, String password2, long phoneNumber, String city) {
		this.username = username;
		this.userMail = userMail;
		this.password1 = password1;
		this.password2 = password2;


		this.phoneNumber = phoneNumber;
        this.city = city;
		 
		
	}
	

	

	



	










	public String getName() {
		return username;
	}

	public String getUserMail() {
		return userMail;
	}

	public  String getpassword1() {
		return password1;
	}

	
	public  long getphoneNumber() {
		return phoneNumber;
	}

	

	public String getcity() {
		// TODO Auto-generated method stub
		return city;
	}


	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", userMail=" + userMail + ", password1=" + password1
				+ ", password2=" + password2 + ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
	}



	
	
	

}
