tracker.directive("searchable",['$http','$parse', function($http, $parse){
	return {
		restrict:"A",
		scope:{
			searchPromise:'&',
			searchUrl:'@',
			searchParams:'=',
			searchResponse:'=',
			searchPostProcess: '&',			
			searchOverwriteUrl:'='
		},
		transclude :true,
		templateUrl: 'resources/partials/searchable.html',
		controller: function($scope, $attrs) {
			this.search = function(searchParams){
				$scope.searchResponse.searching = true;
				var url = "";
				if($attrs.searchUrl) {
					url = $scope.$eval($attrs.searchUrl) + '/?_=' + Math.random();
				} else {
					url = $scope.searchOverwriteUrl  + '/?_=' + Math.random();
				}
				//make sure we have a valid number
				var pageNum = (searchParams.currentPage+'').replace(/\D/g, '') *1;
				searchParams.currentPage = pageNum > 0 ? pageNum:1;
				var params = JSON.parse(JSON.stringify(searchParams));
				params.currentPage = params.currentPage -1;
				if($attrs.searchPromise) {
					$scope.searchPromise({params:params}).then(function(response) {
						if(response.errors && response.errors.length > 0){
							$scope.errors = response.errors;
						}else{
							$scope.errors =[];
							$scope.searchResponse = response.data;
							$scope.searchResponse.currentPage = ($scope.searchResponse.currentPage *1) +1;
							var modVal = (($scope.searchResponse.totalCount*1) % ($scope.searchResponse.pageSize*1));
							if(modVal == 0){
								$scope.searchResponse.lastPage = parseInt((($scope.searchResponse.totalCount*1) / ($scope.searchResponse.pageSize*1)));
							}else{
								$scope.searchResponse.lastPage = parseInt((($scope.searchResponse.totalCount*1) / ($scope.searchResponse.pageSize*1))) + 1;
							}
							if ($scope.searchPostProcess) {
								if($scope.searchResponse.searchResults) {
		    						$.each($scope.searchResponse.searchResults, function(index,result) {
		    						    $scope.searchPostProcess({response:result});
		    			            });
								} 
							}							
						}
						$scope.searchResponse.searching = false;
						
					});	
				} else {
					$http.get(baseUrl + url, {params:params}).success(function(data) {
						$scope.errors =[];
						$scope.searchResponse = data;
						$scope.searchResponse.currentPage = ($scope.searchResponse.currentPage *1) +1;
						var modVal = (($scope.searchResponse.totalCount*1) % ($scope.searchResponse.pageSize*1));
						if(modVal == 0){
							$scope.searchResponse.lastPage = parseInt((($scope.searchResponse.totalCount*1) / ($scope.searchResponse.pageSize*1)));
						}else{
							$scope.searchResponse.lastPage = parseInt((($scope.searchResponse.totalCount*1) / ($scope.searchResponse.pageSize*1))) + 1;
						}
						if ($scope.searchPostProcess) {
							if($scope.searchResponse.searchResults) {
	    						$.each($scope.searchResponse.searchResults, function(index,result) {
	    						    $scope.searchPostProcess({response:result});
	    			            });
							} 
						}						
					}).error(function (data, status, headers, config) {
						$scope.errors =[];
						for(var field in data.messages){
							for(var messages in data.messages[field]){
								$scope.errors.push(data.messages[field][messages]);
							}
						}
						$scope.searchResponse.searching = false;
						return status;
					});						
				}
			};
			
			this.changePage = function(){
				this.search($scope.searchParams);
			};
			
			this.filterChange = function(){
				$scope.searchParams.currentPage = 1;
				this.search($scope.searchParams);
			};
			
			this.sortChange = function(sortKey, element){
				element.parent().children().removeClass("headerSortDown headerSortUp");
		        if ($scope.searchParams.sortKey == sortKey && $scope.searchParams.sortDir == "asc") {
		        	 $scope.searchParams.sortDir = "desc";
		        	 element.addClass('headerSortDown');
		        } else if ($scope.searchParams.sortKey == sortKey && $scope.searchParams.sortDir == "desc") {
		        	 $scope.searchParams.sortDir = "asc";
		        	 element.addClass('headerSortUp');
		        } else {
		        	 $scope.searchParams.sortKey = sortKey;
		        	 $scope.searchParams.sortDir = "asc";
		        	 element.addClass('headerSortUp');
		        }
				this.search($scope.searchParams);
			};
			
			this.search($scope.searchParams);
		},
		link:function(scope, element, attrs){
			
		}
	};
}]);


tracker.directive("searchOnClick", function(){
	return {
		restrict:"A",
		require:"^searchable",
		scope:{
			activeIndicator:'='
		},
		transclude:false,
		link : function(scope, element, attrs, searchableController) {
			element.bind("click", function(){
				searchableController.filterChange();
			});
		}
	};
});

tracker.directive("sortOnClick", function(){
	return {
		restrict:"A",
		require:"^searchable",
		transclude:false,
		link:function(scope, element, attrs, searchableController){
			element.bind('mouseenter', function(){
	            element.addClass('columnHover');
	            element.addClass('headerSortHover');
	        })
	        .bind('mouseleave', function(){
	        	element.removeClass('columnHover');
	        	element.removeClass('headerSortHover');
	        })
			.bind("click", function(){
				searchableController.sortChange(attrs.sortColumn, element);
			});	
		}
	};
});

tracker.directive("export", function($window){
	return {
		restrict:"A",
		transclude :true,
		scope:true,
		templateUrl: 'resources/partials/export.html',
		controller: function($scope, $attrs) {
	  		$scope.exportSearchResults = function(fileType) {
	  	
	  			var  endpoint = $attrs.export + "." + fileType;
	  			//Query URL for current page should less than one
	  			$scope.searchParams.currentPage = $scope.searchParams.currentPage-1;
	  			var paramValues = $.param($scope.searchParams);
	  			//To display page  Values
	  			$scope.searchParams.currentPage = $scope.searchParams.currentPage+1;
	  			$window.open(baseUrl + endpoint + '?'+ paramValues);
	  		};
	  		
		},
		link:function(scope, element, attrs){}
	};
});

tracker.directive("pageable", function(){
	return {
		restrict:"A",
		transclude :true,
		require:"^searchable",
		scope:{
			pagingInfo:'=',
			searchParams:'=',
			changePage:'&'
		},
		templateUrl: 'resources/partials/pageable-table.html',
		controller: function($scope, $attrs) {

			$scope.nextPage = function(){
				$scope.searchParams.currentPage = $scope.searchParams.currentPage + 1;
				$scope.changePage();
			};
			$scope.prevPage = function(){
				$scope.searchParams.currentPage = $scope.searchParams.currentPage - 1;
				$scope.changePage();
			};
			$scope.lastPage = function(){
				
				$scope.searchParams.currentPage = $scope.pagingInfo.lastPage;
				$scope.changePage();
			};
			$scope.firstPage = function(){
				$scope.searchParams.currentPage = 0;
				$scope.changePage();
			};
		},
		link:function(scope, element, attrs, searchableCtrl){
			scope.changePage = function() {
				searchableCtrl.changePage();
			};
		}
	};
});
