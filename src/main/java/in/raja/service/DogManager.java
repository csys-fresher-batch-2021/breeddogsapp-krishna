package in.raja.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.raja.dao.OrderDAO;
import in.raja.dao.ProductDAO;
import in.raja.dao.UserDao;
import in.raja.model.DogDetails;
import in.raja.model.UserDetails;
import in.raja.util.numberValidator;
import in.raja.validate.ProductValidation1;
import in.raja.validate.UserValidate;
import in.raja.validate.userValidation;

public class DogManager {
	public DogManager()
	{
		//default constructor
	}
	
	
	
	
	
	
	
	
	
	
	

	   
	
	
	
	
	
	
	
	
	

	private static final List<DogDetails> userList = new ArrayList<>();
	

	   public static List<DogDetails> displayDog()
	   {   
		   return userList;
	   }
	   

	   
	   
	   public boolean addUser(UserDetails... registerDetails) {
		   boolean added = false;
		   
		   for (UserDetails registerDetails1 : registerDetails ) {
			   if(userValidation.isValidUserDetail( registerDetails1))
					   {
				   try {
						System.out.println(registerDetails1);

					   UserDao user = new UserDao();
					   user.save2(registerDetails1);
				   }
				   catch (SQLException e) {
	                    e.printStackTrace()	;
	                    
				}
				   
				   added=true;   
			   }
		   }
		return added;
	   }
	
	   
	   
	   
	   public boolean addDog(DogDetails... product ) {

			boolean added = false;
			
			for (DogDetails product1 : product)
			{
				if (ProductValidation1.isValidProduct(product1)) {
					try {
						ProductDAO.save(product1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					added = true;
				}
			}
			return added;
		}

	   
	   
	   
	   
	   public static boolean checkAvailable(int dogno) throws Exception {
		    
		    boolean isValid = false;
		    	
		    	
		    List<Integer>  dogNoList = ProductDAO.searchDogAvailability(dogno);
		    for(int number : dogNoList) {
		    	if(number==dogno) {
		    		isValid = true;
		    	}
		    }
			 
			  
		
			return isValid;
	   
	   }
	   
	   
	   
	   
	   
	   
		/*
		 * public List<DogDetails> addStock(DogDetails... products) {
		 * 
		 * boolean added = false; for (DogDetails product : products) { try {
		 * ProductDAO.save(product); } catch (SQLException e) { e.printStackTrace(); }
		 * added = true; } return taskList; }
		 */
	   public static boolean deleteDog(int dogno) throws Exception  {
			
			
			boolean isdeleted=false;
			

			   if(numberValidator.isValidNumber(dogno,"Invalid Dogno"))
			   {
				
				   
				   ProductDAO.delete(dogno);
				   isdeleted=true;
				  
			 
		   }
			   
			   return isdeleted;
		}
		   
		   
		   
		   
	   public static boolean deleteOrder(int dogno) throws Exception  {
			
			
			boolean isdeleted=false;
			

			   if(numberValidator.isValidNumber(dogno,"Invalid Dogno"))
			   {
				
				   
				   OrderDAO.delete(dogno);
				   isdeleted=true;
				  
			 
		   }
			   
			   return isdeleted;
		}
		   
	   
	   
	   
		   
		   
	   public static List<DogDetails> searchBreedByCost(int breedType)
		{

			
			List<DogDetails> costDetails =ProductDAO.findAll();
			
			costDetails.removeAll(costDetails);

			if (breedType == 1)
			{
				for (DogDetails breed : ProductDAO.findAll())
				{
					if (breed.getDogPrice()<=5000 ) {
						costDetails.add(breed);
                      
					}
				}
			}
			else if (breedType == 2)
			{
				for (DogDetails breed : ProductDAO.findAll())
					if (breed.getDogPrice() > 5000 && breed.getDogPrice() <= 10000 ) {
						costDetails.add(breed);
					}
				
			}
					else if (breedType == 3)
					{
						for (DogDetails breed : ProductDAO.findAll())
							if ( breed.getDogPrice() > 10000 ) {
								costDetails.add(breed);
							
							}
				}
			return costDetails;
			}

		   
		   
		   
		   
		   
		 
		   
		   

	
	
	public static boolean isValidPassword(String phonenumber)
    {
  
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (phonenumber == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(phonenumber);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }




	






	
}
	


