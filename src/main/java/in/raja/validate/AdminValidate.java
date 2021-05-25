package in.raja.validate;

import in.raja.service.AdminService;

public class AdminValidate{
		
	 private AdminValidate() {
		    throw new IllegalStateException("Utility class");
		  }
	
		public static boolean validatetAdmin(String phoneNumber, String password1)
		{
			boolean isValid = false;

			if (phoneNumber.length() == 10  && password1.trim().length() == 8)
			{
			isValid = AdminService.getAdminName(phoneNumber);
			}
			return isValid;

		}
}
