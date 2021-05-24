package in.raja.service;

import java.util.ArrayList;
import java.util.List;

import in.raja.model.DogDetails;

public class DogManager {
	private DogManager()
	{
		//default constructor
	}
	
	
	private static final List<DogDetails> taskList = new ArrayList<>();
	

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

	


