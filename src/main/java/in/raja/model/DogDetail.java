package in.raja.model;

public class DogDetail {
	private int dogNo;
	private String dogName;
	private int age;
	private String gender;
	private String place;
	private int price;
	private String insurance;

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

	public DogDetail(String dogname, int age, String gender, String place, int price, String insurance) {

		this.dogName = dogname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.price = price;
		this.insurance = insurance;

	}

	@Override
	public String toString() {
		return "DogDetails [dogno=" + dogNo + ", dogname=" + dogName + ", age=" + age + ", gender=" + gender
				+ ", place=" + place + ", price=" + price + ", insurance=" + insurance + "]";
	}

}
