var timepicker = angular.module('ui.timepicker', [])

.value('uiTimepickerConfig', {
    'step' : 15,
    'maxTime':'11:45 PM',
    'timeFormat': 'h:i A',
    'scrollDefaultTime': "12:00 AM"
});

var baseUrl =  '';
if(document.getElementById('baseUrl')){
 baseUrl = document.getElementById('baseUrl').value;
}

//var tracker = angular.module('tracker', ['ngRoute','ui.router','ui.bootstrap','ngCookies', 'ui.select2', ,'blueimp.fileupload','ui.timepicker','smart-table']);
var tracker = angular.module('tracker', ['ngRoute','ui.router','ui.bootstrap','ngCookies', 'ui.select2', ,'blueimp.fileupload','ui.timepicker']);
tracker.config(['$stateProvider','$routeProvider', '$provide','$httpProvider', function($stateProvider, $routeProvider, $provide, $httpProvider) {
	
	  //register the interceptor as a service
	  $provide.factory('myHttpInterceptor', function($q) {
			return {
		     'responseError': function(rejection) {
		    	if(rejection.status == 0){
		    		location.reload();
		    	}
		 	    return $q.reject(rejection);
		      }
		    };
	  	});
	  
	  $provide.factory('myHttpInterceptor', function($q) {
		  return function(promise) {
		    return promise.then(function(success) {
		      return success;
		    }, function(rejection) {
		    	if(rejection.status == 0){
		    		location.reload();
		    	}
		      return $q.reject(rejection);
		    });
		  };
		});
	  
	  $httpProvider.interceptors.push('myHttpInterceptor');
	  
$stateProvider
     .state('home', {
        url: "",
        views: {
            "uiview": {
                templateUrl: 'resources/partials/create_play.html',
                controller: 'SalesPlayController'
            }
        }
    })

    .state('addsalesplay', {
        url: "/customer/salesplay/{playId}", 
        resolve: {
        	salesPlayId: getSalesId,
        	},           
        views: {
            "uiview": {
                templateUrl: 'resources/partials/create_play_1.html',
                controller: 'PaintPointsController'
            }
        }
    }) 
    .state('productinfo', {
    url: "/productinfo", 
    
    views: {
        "uiview": {
            templateUrl: 'resources/partials/create_play_2.html',
            controller: 'ProductInfoController'
        }
    }
    }) 
    .state('getSalesPlay', {
    	 url: "/customer/getsalesplay/{playId}", 
    	 resolve: {
         	loadedData:salesPlayResolver,
         	},            	 
    	 views: {
        "uiview": {
            templateUrl: 'resources/partials/create_play_product_info.html',
            controller: 'ProductDetailsController'
        }
    }
    }) 
    .state('productdetails', {
        url: "/productdetails", 
        
        views: {
            "uiview": {
                templateUrl: 'resources/partials/create_play_product_info.html',
                controller: 'ProductInfoController'
            }
        }
    }) 
    .state('successUpload', {
        url: "/uploadFile/success", 
        views: {
            "uiview": {
                templateUrl: 'resources/partials/upload-success.html',
                controller: 'UploadFileController'
            }
        }
    })     
 
   }]);
var salesPlayResolver = ['$stateParams','SalesPlayService', function ($stateParams, SalesPlayService) {
	
	if($stateParams.playId) {
		return SalesPlayService.getSalesPlayWithMapping($stateParams.playId); 
	} else {
		return {
			data:{},
			errors:[]
		};
	}											
	}];
var getSalesId = ['$stateParams', function ($stateParams) {
	return $stateParams.playId;
}];