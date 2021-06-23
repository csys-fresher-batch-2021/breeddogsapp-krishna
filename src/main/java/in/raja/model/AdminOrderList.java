package in.raja.model;

public class AdminOrderList {
	
	private int userId ;
	private int orderId;
	private int dogNo;
	private long phoneNo;
	private String address;
	private String status;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDogNo() {
		return dogNo;
	}
	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
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
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public AdminOrderList() {
		
	}
	
	public AdminOrderList(int id,int dogNo, long phoneNo, String address, String status) {
		this.orderId =id;
		this.dogNo = dogNo;
		this.phoneNo = phoneNo;
		this.address = address;
		this.status = status;
	}
	public AdminOrderList(Integer userId , Integer dogNo2, long phoneNo2, String address2) {
		this.userId=userId;
		
		this.dogNo = dogNo2;

		this.phoneNo = phoneNo2;
		this.address = address2;
	}
	
	
	public AdminOrderList(int orderId2, int dogNo2, long userPhoneNo, String userAddress, String status2, int userId2) {
		this.userId=userId2;
		this.orderId=orderId2;
		this.dogNo = dogNo2;
		this.status = status2;

		this.phoneNo = userPhoneNo;
		this.address = userAddress;
	}
	

	public AdminOrderList(Integer dogNo2, long phoneNo2, String address2, String status2, int id , int orderId) {
		this.dogNo = dogNo2;
		this.phoneNo = phoneNo2;
		this.address = address2;
		this.status = status2;
		this.userId =id;
		this.orderId=orderId;


	}

	@Override
	public String toString() {
		return "AdminOrderList [userid=" + userId + ", orderId=" + orderId + ", dogno=" + dogNo + ", phoneno=" + phoneNo
				+ ", address=" + address + ", status=" + status + "]";
	}

	
	
}





