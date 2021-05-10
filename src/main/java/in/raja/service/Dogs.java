package in.raja.service;

import java.util.ArrayList;

public class Dogs {

	private static ArrayList<DogDetails> dogList = new ArrayList<DogDetails>();

	static {
		
		

		DogDetails details0 = new DogDetails();
		details0.dogno=0;
		details0.dogname = "Labrador";
		details0.age = "29days";
		details0.gender = "male";
		details0.color = "black";
		details0.place = "Madurai";
		details0.price = 14000;
		details0.insurance = "yes";

		DogDetails details1 = new DogDetails();
		details1.dogno=1;

		details1.dogname = "bulldog";
		details1.age = "29days";
		details1.gender = "male";
		details1.color = "white";
		details1.place = "chennai";
		details1.price = 24000;
		details1.insurance = "no";

		DogDetails details2 = new DogDetails();
		details2.dogno=2;

		details2.dogname = "GreatDane";
		details2.age = "39days";
		details2.gender = "female";
		details2.color = "fawn";
		details2.place = "sivakasi";
		details2.price = 17000;
		details2.insurance = "yes";

		DogDetails details3 = new DogDetails();
		details3.dogno=3;

		details3.dogname = "Labrador";
		details3.age = "29days";
		details3.gender = "male";
		details3.color = "white";
		details3.place = "Madurai";
		details3.price = 12000;
		details3.insurance = "no";

		DogDetails details4 = new DogDetails();
		details4.dogno=4;

		details4.dogname = "Labrador";
		details4.age = "30days";
		details4.gender = "male";
		details4.color = "black";
		details4.place = "chennai";
		details4.price = 10000;
		details4.insurance = "yes";

		DogDetails details5 = new DogDetails();
		details5.dogno=5;

		details5.dogname = "GreatDane";
		details5.age = "29days";
		details5.gender = "male";
		details5.color = "black";
		details5.place = "Madurai";
		details5.price = 15000;
		details5.insurance = "yes";

		addlist(details0);
		addlist(details1);
		addlist(details2);
		addlist(details3);
		addlist(details4);
		addlist(details5);
		
		
		
		
	}
	
	public static void addlist(DogDetails details) {
		dogList.add(details);
	}
	
	
		
	public static ArrayList<DogDetails> getDogs(){
		return dogList;
		
	}
	
	
		

}
