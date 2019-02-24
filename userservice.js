/**
 * UserService
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.userRegistration=function(user){
	return	$http.post("http://localhost:8081/collaborationMiddle/registration",user)
	}
	userService.login=function(user){
		return $http.post("http://localhost:8081/collaborationMiddle/login",user)
	}
	userService.logout=function(){
		return $http.put("http://localhost:8081/collaborationMiddle/logout")
	}
	userService.getuser=function(){
		return $http.get("http://localhost:8081/collaborationMiddle/getuser")
	}
	userService.updateUser=function(user){
		return $http.put("http://localhost:8081/collaborationMiddle/updateuser",user)
	}
	
	
	return userService;
})

