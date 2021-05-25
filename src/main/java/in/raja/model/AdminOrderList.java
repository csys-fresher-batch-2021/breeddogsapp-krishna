package in.raja.model;

public class AdminOrderList {
	
	
	
	private int dogno;
	private String address;
	public int getDogno() {
		return dogno;
	}
	public void setDogno(int dogno) {
		this.dogno = dogno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AdminOrderList(int dogno, String address) {
		this.dogno = dogno;
		this.address = address;
	}
	@Override
	public String toString() {
		return "AdminOrderList [dogno=" + dogno + ", address=" + address + "]";
	}

	
	
}







