package in.raja.model;

public class AdminOrderList {
	
	
	
	private int dogno;
	private long phoneno;
	private String address;
	@Override
	public String toString() {
		return "AdminOrderList [dogno=" + dogno + ", phoneno=" + phoneno + ", address=" + address + "]";
	}
	public int getDogno() {
		return dogno;
	}
	public void setDogno(int dogno) {
		this.dogno = dogno;
	}
	
	public long getphoneno() {
		return phoneno;
	}
	
	public void setphoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AdminOrderList(int dogno,long phoneno, String address) {
		this.dogno = dogno;
		this.address = address;
		this.phoneno = phoneno;
	}
	
	
}







