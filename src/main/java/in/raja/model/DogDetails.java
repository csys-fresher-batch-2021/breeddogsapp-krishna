package in.raja.model;

public class DogDetails {
	private int dogno;
	private String dogname;
	private String age;
	private String gender;
	private String place;
	private int price;
	private String insurance;

	public int getDogNo() {
		return dogno;
	}
	public String getDogName() {
		return dogname;
	}

	public String getDogAge() {
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

	public DogDetails(int dogno, String dogname, String age, String gender, String place, int price, String insurance) {

		this.dogno = dogno;
		this.dogname = dogname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.price = price;
		this.insurance = insurance;

	}

	

	public DogDetails(Integer dogNo2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DogDetails [dogno=" + dogno + ", dogname=" + dogname + ", age=" + age + ", gender=" + gender
				+ ", place=" + place + ", price=" + price + ", insurance=" + insurance + "]";
	}

}
