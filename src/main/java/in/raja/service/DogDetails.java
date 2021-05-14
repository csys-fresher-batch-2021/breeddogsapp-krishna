package in.raja.service;






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
	
	
	/*
	 * public void setName(int dogno) { this.dogno = dogno; }
	 * 
	 */
	public String getDogName() {
		return dogname;
	}

	/*
	 * public void setDogName(String dogname) { this.dogname = dogname; }
	 */
	
	

	public String getDogAge() {
		return age;
	}

	/*
	 * public void setDogAge(String age) { this.age = age; }
	 */
	
	
	

	public String getDogGender() {
		return gender;
	}
	
	
	
	/*
	 * public void setDogGender(String gender) { this.gender = gender; }
	 */
	
	

	public String getDogPlace() {
		return place;
	}

	/*
	 * public void setDogPlace(String place) { this.place = place; }
	 */
	
	
	
	public int getDogPrice() {
		return price;
	}
	/*
	 * public void setDogPrice(int price) { this.price = price; }
	 */

	public String getDogInsurance() {
		return insurance;
	}

	
	
	/*
	 * public void setDogInsurance(String insurance) { this.insurance = insurance; }
	 * 
	 */
	
		
	
	public DogDetails(int dogno, String dogname, String age, String gender, String place, int price,
			String insurance) {
		
		this.dogno = dogno;
		this.dogname = dogname;
		this.age = age;
		this.gender = gender;
		this.place = place;
		this.price = price;
		this.insurance = insurance;	
		
	}

	

	@Override
	public String toString() {
		return "DogDetails [dogno=" + dogno + ", dogname=" + dogname + ", age=" + age + ", gender=" + gender
				+ ", place=" + place + ", price=" + price + ", insurance=" + insurance + "]";
	}

	

	

}
	

