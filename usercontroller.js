/**
 * UserCtrl To get UserService= function($http){var
 * userService={},userService.userRegistrion=function(user),return userService}
 */
app.controller('UserCtrl',function($scope,UserService,$location,$rootScope,$cookieStore){
	$scope.userRegistration=function(user){
		// Call a function in a service and pass the user object to that
		// function
		UserService.userRegistration(user).then(
				function(response){// change the path to /login
					$location.path('/login')
				},
				function(response){// Display the error message in
									// registrationform.html
					// Send the data from controller to the view		
					// Data is ErrorClazz object
					$scope.error=response.data// response.data is ErrorClazz
												// object
				})
	}
	$scope.login=function(user)
	{ 
		UserService.login(user).then(function(response){


	$rootScope.user=response.data
	$cookieStore.put('userDetails',response.data)
	$location.path('/home')
		},function(response) 
	{
			$scope.error=response.data;
		
			})
	
}
	//This statement has to get executed only for logged in user 
	//(login and registration pages this statement should not get executed)
	if ($rootScope.user!=undefined){
	UserService.getuser().then(function(response){
			$scope.user=response.data
	},function(response){
		console.log(response.status)
		console.log(response.data)
	})
	
	}
			$scope.updateUser=function(user){
				UserService.updateUser(user)
			}
	})
	