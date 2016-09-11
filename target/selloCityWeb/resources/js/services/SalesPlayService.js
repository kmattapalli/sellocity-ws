tracker.factory("SalesPlayService", function($http,$filter,$rootScope){
	var salesPlayObj;
	var service = {
		getResource : function() {
			return 'salesplay';
		},
		
		getHttp : function() {
			return $http;
		},
		setSalesPlayData : function (dataValues){
			this.salesPlayObj=dataValues;
		},
		getSalesPlayData : function (){
			return this.salesPlayObj;
		},		
		getBaseUrl : function() {
			return baseUrl;
		},
		setSalesPlayName : function(name){
			$rootScope.salesPlay=name;
		},
		getSalesPlayWithMapping : function(salesPlayId){
			var url = baseUrl + '/selloCityWeb/customer/getsalesplay/'+salesPlayId;
		    return  $http.get(url).then(this.successHandler, this.errorHandler);
    	},		
	    addSalesPlay : function(salesPlayData,clientLogo){
	    	var fd = new FormData();
	        fd.append('file', clientLogo);
	        fd.append("data", JSON.stringify(salesPlayData));
	    	var method = 'POST';
	    	var url = baseUrl + '/selloCityWeb/customer/salesplay';
	    	return $http.post(url, fd, {
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        }).then(this.successHandler, this.errorHandler);		

		    },	   
		    addPaintPoints : function(salesPlayData,salesPlayId){
		    	var fd = new FormData();
		    	var method = 'PUT';
		    	var url = baseUrl + '/selloCityWeb/customer/salesplay';
		    	url += '/' + salesPlayId;
		    	return $http({
					method: method,
					url: url,
					data: salesPlayData
				}).then(this.successHandler, this.errorHandler);
			    },
			    
			    addProductData : function(infoData,mappingId){
			    	
			    	var fd = new FormData();
			    	//var test=[infoData.painPointImage,infoData.productImage];
			    	fd.append("data", JSON.stringify(infoData.productInfo));
		
			    	fd.append('paintPoint', infoData.painPointImage);
			    	fd.append('productImage', infoData.productImage);
			    	fd.append('productSpecs', infoData.productSpecs);
			    	fd.append('productManuals', infoData.productManuals);

			    	var method = 'POST';
			    	var url = baseUrl + '/selloCityWeb/customer/'+$rootScope.salesPlay+'/productData/'+mappingId;
			    	return $http.post(url, fd, {
			            transformRequest: angular.identity,
			            headers: {'Content-Type': undefined}
			        }).then(this.successHandler, this.errorHandler);	
			    },
		    addProductDetails	 : function(infoData,mappingId){
		    	$rootScope.salesPlay="temp";
			    	var fd = new FormData();
			    	console.log(JSON.stringify(infoData));
			    	//var test=[infoData.painPointImage,infoData.productImage];
			    	fd.append("data", JSON.stringify(infoData));
		
			    	fd.append('productAwards', infoData.productAwards);
			    	fd.append('productClaims', infoData.productClaims);
			    	fd.append('productWhitePapers', infoData.productWhitePapers);
			    	fd.append('productTestimonials', infoData.productTestimonials);

			    	var method = 'POST';
			    	var url = baseUrl + '/selloCityWeb/customer/'+$rootScope.salesPlay+'/productDetails/'+mappingId;
			    	return $http.post(url, fd, {
			            transformRequest: angular.identity,
			            headers: {'Content-Type': undefined}
			        }).then(this.successHandler, this.errorHandler);	
			    },
	};
	return angular.extend(service, BaseService);
});