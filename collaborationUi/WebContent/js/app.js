/**
 * angular module,configuration
 */
var app = angular.module("app", [ 'ngRoute' ])
app.config(function($routeProvider) {
	$routeProvider

	.when('/addjob', {controller : 'JobCtrl',templateUrl : 'views/jobform.html'})
    .when('/getalljobs', {controller : 'JobCtrl',templateUrl : 'views/jobslist.html'})
    // this view can access all $scope variables all $scope functions defined in
	// JobCtrl
	.otherwise({templateUrl : 'views/home.html'
	})
	// this view can access all 
	
})

