package in.raja.service;

import java.util.ArrayList;
import java.util.List;

import in.raja.model.DogDetails;

public class DogManager {
	private DogManager()
	{
		//default constructor
	}
	
	/*
	 * private static final String MADURAI ="Madurai"; private static final String
	 * CHENNAI ="Chennai"; private static final String FEMALE ="Female"; private
	 * static final String MALE ="Male";
	 */
	private static final List<DogDetails> taskList = new ArrayList<>();
	
	/*
	 * static {
	 * 
	 * 
	 * 
	 * 
	 * DogDetails task1 = new DogDetails(0,"Labrador","21days", MALE ,MADURAI ,
	 * 12000 , "yes"); DogDetails task2 = new DogDetails(1,"Bulldog","23days",
	 * FEMALE, MADURAI , 17000 , "no"); DogDetails task3 = new
	 * DogDetails(2,"Labrador","31days", MALE ,CHENNAI, 12600 , "no"); DogDetails
	 * task4 = new DogDetails(3,"GreatDane","27days", FEMALE , MADURAI, 12900 ,
	 * "yes");
	 * 
	 * 
	 * 
	 * taskList.add(task1); taskList.add(task2); taskList.add(task3);
	 * taskList.add(task4); }
	 */

	   public static List<DogDetails> displayDog()
	   {   
		   return taskList;
	   }
	   public static void addDog(int dogno,String dogname, String age,String gender,String place, int price, String insurance)
	   {   
		   DogDetails task1 = new DogDetails(dogno,dogname,age,gender,place,price,insurance);
		   taskList.add(task1);
	
       }
	   
	   
	   
	   public static boolean deleteDog(int dogno)  {
			
			
			boolean isdeleted=false;
			
			
	  int index=0;
		   for(DogDetails name:taskList )
	   {
			   if(name.getDogNo()==(dogno))
			   {
				
				   index++;
				  
				   break;
			 
		   }
		}
		   if(index>0){
		       taskList.remove(dogno);
			   isdeleted=true;
		   }
		   return isdeleted;
		  
	}
	public static  boolean checkAvailable(Integer dogno) {
		boolean isvalid=false;

		   for(DogDetails name2:taskList )
		   {
			   if(name2.getDogNo()==(dogno)) {
				   
				isvalid=true;   
			   }
		   }
		return isvalid;
	}
}

	


