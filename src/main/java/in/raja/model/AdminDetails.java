package in.raja.model;

public class AdminDetails {
	private String name;
	private  long phoneNumber;
	private  String passWord;
	
	public  AdminDetails(String name,long phoneNumber,String passWord){

		this.name=name;
		this.phoneNumber=phoneNumber;
		this.passWord=passWord;
	}
	
	
	

	

	
	public String getName() {
		return name;
	}

	public  long getPhoneNumber() {
		return phoneNumber;
	}
	public  String getPassWord() {
		return passWord;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", phoneNumber=" + phoneNumber + ", passWord=" + passWord + "]";
	}

	
}
