/*jshint smarttabs: true */

tracker.directive('dateParser', function($filter){
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function(scope, element, attrs,modelCtrl){
			   var dateValue = function(inputValue) {
		        	if(inputValue) {
			           var dateValued =  $filter('date')(inputValue, "yyyy-MM-dd");
			            modelCtrl.$setViewValue(dateValued);
			              modelCtrl.$render();
			           return dateValued;
		        	}
		         };
		         modelCtrl.$parsers.push(dateValue);
		         dateValue(scope[attrs.ngModel]);
		     }
	};
});
tracker.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
tracker.directive('datepickerPopup', function (dateFilter, datepickerPopupConfig,$filter) {
    return {
        restrict: 'A',
        priority: 1,
        require: 'ngModel',
        link: function(scope, element, attr, ngModel,modelCtrl) {
            var dateFormat = attr.datepickerPopup || datepickerPopupConfig.datepickerPopup;
            ngModel.$formatters.push(function (value) {
            	   var dateValued =  $filter('date')(value, "MM-dd-yyyy");
//		              modelCtrl.$setViewValue(dateValued);
//		              modelCtrl.$render();
	            return dateFilter(value, dateFormat);
                
                
            });
        }
    };
});
tracker.directive("incidentSearchAutoComplete", function(IncidentService, $timeout) {
    return {
        restrict : "A",
        replace: true,
        require: ["ngModel"],
        scope:true,
        transclude : false,
        controller : function($scope, $attrs) {
            $scope.filterIncidents = function(searchVal) {   
            	if(searchVal){
	                return IncidentService.searchIncident(searchVal).then(
	                        function(loadedData) {
	                            return loadedData.data;
	                        }
	                    );
	                };     
        		}
            },
        link : function(scope, element, attrs, ctrls) {
        	
        	$(element).bind('focus', function() {
                $timeout(function() { // timeout necessary for IE10 to work..
                    ctrls[0].$setViewValue(ctrls[0].$viewValue ? ctrls[0].$viewValue : " ");
                }, 1);
            });
        	
			element.bind("select", function(){
				scope.changeEntityId(scope.$eval(ngModel));
//				if(attrs.ngModel=='incidentNo'){
//					scope.changeEntityId(scope.$eval(ngModel));
//				}
				
//				if(attrs.ngModel=='incidentNo'){
//					console.log("AAA"+scope.$eval(attrs.ngModel));
//				}
//					scope.changeEntityId(scope.$eval(ngModel));
////				}
			
			});	
        }
    };
});