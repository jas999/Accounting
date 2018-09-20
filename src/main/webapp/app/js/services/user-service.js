angular.module("accounting").service('UserService', function($q, $http){
	var signup = function(postData){
	    return $q(function(resolve, reject) {
	    	var signupApi = 'api/users/';
		      $http.post(signupApi,postData).then(function(resp){
		        resolve(resp);
		      }, function(error){
		        console.log(error)
		      });
	    });
	  };
	  
	  var login = function(postData){
	    return $q(function(resolve, reject) {
	    	var signupApi = 'auth/user/authenticate';
		      $http.post(signupApi,postData).then(function(resp){
		        resolve(resp);
		      }, function(error){
		        console.log(error)
		      });
	    });
	  };
	  
	  var validateSignup = function(signup) {
		  var validateResponse = {valid:true};
		 /* if (signup.password != signup.confirmPassword) {
			  validateResponse['valid'] = false;
			  validateResponse['message'] = 'Password/Confirm Password did not match.';
		  } */
		  return validateResponse;
	  }
	  
	  var getLoginBanner = function(postData){
	    return $q(function(resolve, reject) {
	    	var loginBannerApi = '/find/bannersByScreen?screen=login';
		      $http.post(loginBannerApi,postData).then(function(resp){
		        resolve(resp);
		      }, function(error){
		        console.log(error)
		      });
	    });
	  };
	  
	  var getAllCities = function(){
		    return $q(function(resolve, reject) {
		    	var citiesApi = '/fetch/all/cities';
			      $http.get(citiesApi).then(function(resp){
			        resolve(resp);
			      }, function(error){
			        console.log(error)
			      });
		    });
		  };
		  
	  var getAllUsers = function(){
		    return $q(function(resolve, reject) {
		    	var usersApi = '/fetch/all/users';
			      $http.get(usersApi).then(function(resp){
			        resolve(resp);
			      }, function(error){
			        console.log(error)
			      });
		    });
		  };
		  
	var updateUser = function(user){
		return $q(function(resolve, reject) {
	    	var usersApi = '/api/update/specialAccount';
		      $http.post(usersApi,user).then(function(resp){
		        resolve(resp);
		      }, function(error){
		        console.log(error)
		      });
	    });
	}
	  
	  return {
		  signup:signup,
		  login:login,
		  validateSignup:validateSignup,
		  getLoginBanner:getLoginBanner,
		  getAllCities:getAllCities,
		  getAllUsers:getAllUsers,
		  updateUser:updateUser
	  }
	  
});
