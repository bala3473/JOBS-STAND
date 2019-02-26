/**
 * BlogPostCtrl
 */
app.controller('BlogPostCtrl',function($scope,BlogPostService,$location,$roootScope){
//Add a blog
	//How to get blogpost object from the view?
	//View to Controller
	//Call a function from view
	$scope.addBlogPost=function(blogPost){ //ADDING A FUNCTION IN $scope
		//pass the blogpost to BlogService.addBlogPost()	
		BlogPostService.addBlogPost(blogPost).then(function(response){
			alert('BlogPost added successfully is waiting for approval')
			$location.path('/home')},
			function(response){
				if(response.status==401)
					$location.path('/login')
					$scope.error=response.data
			})
	}
})
	
	
	