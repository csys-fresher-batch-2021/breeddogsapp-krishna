package in.raja.model;

import java.io.InputStream;

public class DogDetail {
	private InputStream dogImageByte;
	private String dogImage;
	private int dogNo;
	private String dogName;
	private int age;
	private String gender;
	private String place;
	private int price;
	private String insurance;

	public String getDogImage() {
		return dogImage;
	}

	public int getDogNo() {
		return dogNo;
	}

	public String getDogName() {
		return dogName;
	}

	public int getDogAge() {
		return age;
	}

	public String getDogGender() {
		return gender;
	}

	public String getDogPlace() {
		return place;
	}

	public int getDogPrice() {
		return price;
	}

	public String getDogInsurance() {
		return insurance;
	}

	public DogDetail(int dogno, String dogname, int age, String gender, String place, int price, String insurance) {

		this.dogNo = dogno;
		this.dogName = dogname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.price = price;
		this.insurance = insurance;

	}

	public DogDetail(InputStream dogimage2, int dogno2, String dogname, int age, String gender, String place, int price,
			String insurance) {
		this.dogImageByte = dogimage2;
		this.dogNo = dogno2;
		this.dogName = dogname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.price = price;
		this.insurance = insurance;

	}

	public DogDetail(String dogImage2, int dogNo, String dogName2, int age2, String gender2, String place2,
			Integer price2, String insurance2) {
		this.dogImage = dogImage2;
		this.dogNo = dogNo;
		this.dogName = dogName2;
		this.age = age2;
		this.gender = gender2;
		this.place = place2;
		this.price = price2;
		this.insurance = insurance2;
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

	@Override
	public String toString() {
		return "DogDetail [dogImage=" + dogImage + ", dogNo=" + dogNo + ", dogName=" + dogName + ", age=" + age
				+ ", gender=" + gender + ", place=" + place + ", price=" + price + ", insurance=" + insurance + "]";
	}

}
