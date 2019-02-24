package emp.enq.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import emp.enq.dao.UserDao;
import emp.enq.models.ErrorClazz;
import emp.enq.models.User;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> userRegistration(@RequestBody User user) {

		// read the data from the request body
		// check if email is unique
		if (!userDao.isEmailUnique(user.getEmail())) {// if email is not unique
			ErrorClazz errorClazz = new ErrorClazz(1, "Email already exists.. pls choose different email id");
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!userDao.isPhonenumberUnique(user.getPhonenumber())) {
			ErrorClazz errorClazz = new ErrorClazz(2, "Phone number already exists.. pls enter another phonenumber");
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (user.getRole() == " " || user.getRole() == null) {
			ErrorClazz errorClazz = new ErrorClazz(3, "Role cannot be null..");
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			userDao.userRegistration(user);
		} catch (Exception e) {
			ErrorClazz errorClazz = new ErrorClazz(4, "Unable to register user datails.." + e.getMessage());
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {// user in json
			String email = (String)session.getAttribute("loginId");																		// fmt,{'email':'...','possword':'...'}
		User validUser=userDao.login(user);
		if(validUser==null) {// invalid credentials
			ErrorClazz errorClazz=new ErrorClazz(5, "Email/possword is incorrect..Please enter valid credentials...");
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.UNAUTHORIZED);
		} else{// valid credentials
			System.out.println("Session Id is " + session.getId());
			System.out.println("Session createdTime " + session.getCreationTime());
			validUser.setOnline(true);
			// Update the data in the table.
			userDao.updateUser(validUser);
			session.setAttribute("loginId", user.getEmail());// Adding an attribute in HttpSession only in login method
			return new ResponseEntity<User>(validUser, HttpStatus.OK);
		}
	}

	@RequestMapping(value ="/logout", method= RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session) {
		String email = (String) session.getAttribute("loginId");
		if (email == null) {
			ErrorClazz errorClazz = new ErrorClazz(6, "please login");
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.UNAUTHORIZED);
		}
		User user=userDao.getUser(email);
		user.setOnline(false);
		userDao.updateUser(user);

		// remove the session attribute login Id
		session.removeAttribute("loginId");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(HttpSession session) {
		String email = (String) session.getAttribute("loginId");
		if (email == null) {
			ErrorClazz errorClazz = new ErrorClazz(6, "please login");
			return new ResponseEntity<ErrorClazz>(errorClazz, HttpStatus.UNAUTHORIZED);

		}
		User user = userDao.getUser(email);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
    @RequestMapping(value="/updateuser",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User user,HttpSession session){
		String email=(String)session.getAttribute("loginId");
		//User is not Authenticated
		 if(email==null){
			 ErrorClazz errorClazz=new ErrorClazz(5,"Please login..");
			 return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);//401 - login.html
		 }
		 //Check if the updated phonenumber is unique
		 if(!userDao.isPhonenumberUnique(user.getPhonenumber())){
				ErrorClazz errorClazz=new ErrorClazz(1,"Phone number already exists.. pls enter another phonenumber");
				return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 if(user.getRole()=="" || user.getRole()==null){
				ErrorClazz errorClazz=new ErrorClazz(4,"Role cannot be null..");
				return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 try {
		 userDao.updateUser(user);}
		 catch(Exception e) {
			 ErrorClazz errorClazz=new ErrorClazz(5,"unable to update user details");
			 return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 return new ResponseEntity<Void>(HttpStatus.OK);
	}
}