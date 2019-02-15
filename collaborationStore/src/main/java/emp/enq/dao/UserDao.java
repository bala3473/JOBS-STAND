package emp.enq.dao;

import emp.enq.models.User;

public interface UserDao {
	
	void userRegistrtion(User user);
	boolean isEmailUnique(String email);
   boolean isPhonenumberUnique(String phonenumber)
}
