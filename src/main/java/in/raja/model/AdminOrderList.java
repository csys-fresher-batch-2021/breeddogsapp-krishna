package in.raja.model;

public class AdminOrderList {
	
	private int userid ;
	private int orderId;
	private int dogno;
	private long phoneno;
	private String address;
	private String status;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getDogno() {
		return dogno;
	}
	public void setDogno(int dogno) {
		this.dogno = dogno;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	public AdminOrderList(int id,int dogno, long phoneno, String address, String status) {
		this.orderId =id;
		this.dogno = dogno;
		this.phoneno = phoneno;
		this.address = address;
		this.status = status;
	}
	public AdminOrderList(Integer userId , Integer dogno2, long phoneno2, String address2) {
		this.userid=userId;
		
		this.dogno = dogno2;

		this.phoneno = phoneno2;
		this.address = address2;
	}
	
	
	public AdminOrderList(int orderId2, int dogno2, long userPhoneno, String userAddress, String status2, int userId2) {
		this.userid=userId2;
		this.orderId=orderId2;
		this.dogno = dogno2;
		this.status = status2;

		this.phoneno = userPhoneno;
		this.address = userAddress;
	}
	

	public AdminOrderList(Integer dogno2, long phoneno2, String address2, String status2, int id) {
		this.dogno = dogno2;
		this.phoneno = phoneno2;
		this.address = address2;
		this.status = status2;
		this.userid =id;


	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "AdminOrderList [userid=" + userid + ", orderId=" + orderId + ", dogno=" + dogno + ", phoneno=" + phoneno
				+ ", address=" + address + ", status=" + status + "]";
	}
	
	
	
}





