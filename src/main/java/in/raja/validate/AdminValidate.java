package in.raja.validate;

import in.raja.service.AdminService;

public class AdminValidate{
		
		public static boolean validatetAdmin(String phoneNumber, String password1) {
			boolean isValid = false;

			long mobileNo = Long.parseLong(phoneNumber);
			if (phoneNumber.length() == 10  && password1.trim().length() == 8) {
			isValid = AdminService.getAdminName(phoneNumber);
			}
			return isValid;

		}
}
