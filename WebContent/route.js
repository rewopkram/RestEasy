 
            var app = angular.module("myApp",["ngRoute"]);
           app.config(function($routeProvider) {
            	$routeProvider
            	.when("/", {
            		templateUrl : "welcome.html"
            	})
            	.when("/search", {
            		templateUrl : "rsearch.html"
            	})
            	.when("/list", {
            		templateUrl : "rlist.html"
            	})
            	.when("/details", {
            		templateUrl : "rdetails.html"
            	});;
            }); 
            
            app.controller('myCtrl', function($scope, $http) {  
            	// initialise searchBy scope variable
            	//$scope.searchBy = "Richie Taferner";
            	
            	// declare search function to retrieve full person details when row in table clicked
            	$scope.search = function(x) {
            		//alert("search by " + x);
            		$scope.searchBy = x;
            		//alert("searching");
            		$http({
                		url: 'rest/jsond',
                		method: 'GET',
                		params: {
                			name: $scope.searchBy
                		}
                	}).then(function (response) {
                		$scope.person = response.data.person;
                		$scope.statuscode = response.status;
                        $scope.statustext = response.statusText;
                	}, function(response) {
                        $scope.person = "something went wrong";
                        $scope.statuscode = response.status;
                        $scope.statustext = response.statusText;
                	});      
            	};
            	
            	// call rest list service to retrieve all persons
            	$http({
            		url: 'rest/jsonl',
            		method: 'GET'
            	}).then(function (response) {
            		$scope.myData = response.data.paginatedListWrapper.list;
            		//$scope.person = response.data.person;
            		$scope.statuscode = response.status;
                    $scope.statustext = response.statusText;
            	}, function(response) {
                    $scope.person = "something went wrong";
                    $scope.statuscode = response.status;
                    $scope.statustext = response.statusText;
            	}); 
            	
            	$scope.orderByMe = function(x) {
            		$scope.myOrderBy = x;
            	};
            	
            });
 
