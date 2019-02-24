/**
 * angular module,configuration
 */
var app = angular.module("app", [ 'ngRoute','ngCookies'])
app.config(function($routeProvider) {
	$routeProvider

	.when('/addjob', {controller : 'JobCtrl',templateUrl : 'views/jobform.html'})
    .when('/getalljobs', {controller : 'JobCtrl',templateUrl :'views/jobslist.html'})
    .when('/signup',{controller : 'UserCtrl',templateUrl:'views/registration.html'})
    .when('/login',{controller:'UserCtrl',templateUrl :'views/login.html'})
    .when('/updateuser',{controller:'UserCtrl',templateUrl:'views/updateuser.html'})
    // this view can access all $scope variables all $scope functions defined in
	// JobCtrl
	.otherwise({templateUrl : 'views/home.html'
	})
	// this view can access all
	
})
app.run(function($rootScope,UserService,$location,$cookieStore){//when module gets instantiated, get newly created $rootScope, add logout function to the $rootScope objecgt
	alert('app.run function is getting executed...')
	//Adding a function logout() in $rootScope
	//restore the logged in user details from cookieStore
	//$rootScope.user 
	
	if($rootScope.user==undefined)
	   $rootScope.user=$cookieStore.get('userDetails')
		
	$rootScope.logout=function(){
		alert('Logout function in UserCtrl in $rootScope object')
		UserService.logout().then(
				function(response){
					delete $rootScope.user
					$cookieStore.remove('userDetails')
					$location.path('/login')
				},
				function(response){
					if(response.status==401)
						$location.path('/login')
				})
	}
	//Get the user details from cookie and assign it to the $rootScope variable 'user'
	
})


