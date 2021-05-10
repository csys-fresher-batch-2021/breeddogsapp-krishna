package in.raja.service;

public class DogDetails {
                                                                                                                                
	public int dogno;
	public String age;
	public String gender;
	public String color;
	public String place;
	public int price;
	public String insurance;
	public String dogname;
	
	@Override
	public String toString() {
		return "DogDetails [dogno=" + dogno + ", age=" + age + ", gender=" + gender + ", color=" + color + ", place="
				+ place + ", price=" + price + ", insurance=" + insurance + ", dogname=" + dogname + "]";
	}
}
