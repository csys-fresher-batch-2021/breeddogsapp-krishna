package in.raja.service;

import java.util.ArrayList;
import java.util.List;

public class DogManager {
	private DogManager()
	{
		//default constructor
	}
	
	private static final List<DogDetails> taskList = new ArrayList<>();
	   static
	   {
		   
		 
		   
		   
		DogDetails task1 = new DogDetails(0,"Labrador","21days", "male" , "madurai" , 12000 , "yes");	
		DogDetails task2 = new DogDetails(1,"Bulldog","23days", "female" , "madurai" , 17000 , "no");	
		DogDetails task3 = new DogDetails(2,"Labrador","31days", "male" , "chennai" , 12600 , "no");	
		DogDetails task4 = new DogDetails(3,"GreatDane","27days", "female" , "madurai" , 12900 , "yes");	

		 
	
			taskList.add(task1);
			taskList.add(task2);
			taskList.add(task3);
			taskList.add(task4);
	}
//	   public static boolean displayDog(String name)
//	   { boolean valid=false;
//		 for(DogDetails detail:taskList)
//		 {   
//			 if(detail.getDogName().equalsIgnoreCase(name))
//			 {
//				 
//				 valid=true;
//			 }
//			 
//		 }
//		
//		 return valid;
//	    }
	   public static List<DogDetails> displayDog()
	   {   
		   return taskList;
	   }
	   public static void addDog(int dogno,String dogname, String age,String gender,String place, int price, String insurance)
	   {   
		   DogDetails task1 = new DogDetails(dogno,dogname,age,gender,place,price,insurance);
		   taskList.add(task1);
	   
       }
}
	


