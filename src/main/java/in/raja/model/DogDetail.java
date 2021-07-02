package in.raja.model;

import java.io.InputStream;

public class DogDetail {

	public InputStream getDogImageByte() {
		return dogImageByte;
	}

	public void setDogImageByte(InputStream dogImageByte) {
		this.dogImageByte = dogImageByte;
	}

	public String getDogImage() {
		return dogImage;
	}

	public void setDogImage(String dogImage) {
		this.dogImage = dogImage;
	}

	public int getDogNo() {
		return dogNo;
	}

	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	private InputStream dogImageByte;
	private String dogImage;
	private int dogNo;
	private String dogName;
	private int age;
	private String gender;
	private String place;
	private int price;
	private String insurance;

	public DogDetail(int dogno, String dogname, int age, String gender, String place, int price, String insurance) {

		this.dogNo = dogno;
		this.dogName = dogname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.price = price;
		this.insurance = insurance;

	}

	public DogDetail(String dogimage2, String dogname2, int dogage, String doggender, String doglocation, int dogprice,
			String doginsurance) {
		this.dogImage = dogimage2;
		this.dogName = dogname2;

		this.age = dogage;
		this.gender = doggender;
		this.place = doglocation;
		this.price = dogprice;
		this.insurance = doginsurance;

	}

	public DogDetail() {
		// default constructor
	}

	@Override
	public String toString() {
		return "DogDetail [dogImage=" + dogImage + ", dogNo=" + dogNo + ", dogName=" + dogName + ", age=" + age
				+ ", gender=" + gender + ", place=" + place + ", price=" + price + ", insurance=" + insurance + "]";
	}

}
