package in.raja.service;


public class AvailableDogs {

	
	
	public static void display() {
		System.out.println("-------------");
		for(DogDetails allDogs : Dogs.getDogs()) {
			System.out.println("all details" + " " + allDogs);
		}

	
	
}
}