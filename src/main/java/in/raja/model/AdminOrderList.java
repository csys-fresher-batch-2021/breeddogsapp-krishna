package in.raja.model;

import java.time.LocalDateTime;

public class AdminOrderList {

	private int userId;
	private int orderId;
	private int dogNo;
	private long phoneNo;
	private String address;
	private String status;
	private LocalDateTime orderDate;
	private LocalDateTime deliveryDate;

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

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

	public AdminOrderList(int id, int dogNo, long phoneNo, String address, String status) {
		this.orderId = id;
		this.dogNo = dogNo;
		this.phoneNo = phoneNo;
		this.address = address;
		this.status = status;
	}

	public AdminOrderList(Integer userId, Integer dogNo2, long phoneNo2, String address2) {
		this.userId = userId;

		this.dogNo = dogNo2;

		this.phoneNo = phoneNo2;
		this.address = address2;
	}

	public AdminOrderList(Integer dogNo2, long phoneNo2, String address2, String status2, int id, int orderId) {
		this.dogNo = dogNo2;
		this.phoneNo = phoneNo2;
		this.address = address2;
		this.status = status2;
		this.userId = id;
		this.orderId = orderId;

	}

	public AdminOrderList(Integer dogNo2, long phoneNo2, String address2, String status2, int id, int orderId,
			LocalDateTime orderDate, LocalDateTime deliveryDate) {
		this.dogNo = dogNo2;
		this.phoneNo = phoneNo2;
		this.address = address2;
		this.status = status2;
		this.userId = id;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;

	}

	@Override
	public String toString() {
		return "AdminOrderList [userId=" + userId + ", orderId=" + orderId + ", dogNo=" + dogNo + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + "]";
	}

}
