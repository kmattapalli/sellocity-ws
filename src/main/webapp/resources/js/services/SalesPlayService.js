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
		getPainpoints : function(salesPlayId){
			var url = baseUrl + '/selloCityWeb/customer/getsalesplay/paintpoints/'+salesPlayId;
		    return  $http.get(url).then(this.successHandler, this.errorHandler);
		},
		getSalesPlayWithMapping : function(salesPlayId){
			var url = baseUrl + '/selloCityWeb/customer/getsalesplay/'+salesPlayId;
		    return  $http.get(url).then(this.successHandler, this.errorHandler);
    	},	
		getSalesPlayWithProducts : function(salesPlayId){
			var url = baseUrl + '/selloCityWeb/customer/getsalesplay/products/'+salesPlayId;
		    return  $http.get(url).then(this.successHandler, this.errorHandler);
    	},	
		getSalesPlayData : function(salesPlayId){
			var url = baseUrl + '/selloCityWeb/customer/salesplay/getsalesplay/'+salesPlayId;
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
			    	//fd.append("data", JSON.stringify(infoData));
			    	fd.append("data", infoData.productInfo);
			    	fd.append("specId", infoData.specId);
			    	fd.append("manualId", infoData.manualId);
			   
		
			    	fd.append('paintPoint', infoData.painPointImage);
			    	fd.append('productImage', infoData.productImage);
			    	fd.append('productSpecs', infoData.productSpecs);
			    	fd.append('productManuals', infoData.productManuals);

			    	var method = 'POST';
			    	var url = baseUrl + '/selloCityWeb/customer/productData/'+mappingId;
			    	return $http.post(url, fd, {
			            transformRequest: angular.identity,
			            headers: {'Content-Type': undefined}
			        }).then(this.successHandler, this.errorHandler);	
			    },
		    addProductDetails	 : function(infoData,mappingId){
		    	var productData =[];
		    	var count =0;
		    	$rootScope.salesPlay="temp";
		    		if(infoData.productValues1){
		    			productData[count]=infoData.productValues1;
		    			count++;
		    		}
		    		if(infoData.productValues2){
		    			productData[count]=infoData.productValues2;
		    			count++;
		    		}
		    		if(infoData.productValues3){
		    			productData[count]=infoData.productValues3;
		    			count++;
		    		}
		    		if(infoData.productValues4){
		    			productData[count]=infoData.productValues4;
		    			count++;
		    		}
			    	var fd = new FormData();
			    	console.log(JSON.stringify(infoData));
			    	//var test=[infoData.painPointImage,infoData.productImage];
			    	
			    	fd.append("data", productData);
		
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
			    addBenefitDetails	 : function(infoData,mappingId){
			    	var productData =[];
			    	var count =0;

			    		if(infoData.productValues1){
			    			productData[count]=infoData.productValues1;
			    			count++;
			    		}
			    		if(infoData.productValues2){
			    			productData[count]=infoData.productValues2;
			    			count++;
			    		}
			    		if(infoData.productValues3){
			    			productData[count]=infoData.productValues3;
			    			count++;
			    		}
			    		if(infoData.productValues4){
			    			productData[count]=infoData.productValues4;
			    			count++;
			    		}
				    	var fd = new FormData();
				    	console.log(JSON.stringify(infoData));
				    	//var test=[infoData.painPointImage,infoData.productImage];
				    	
				    	fd.append("benefitsData", productData);
	

				    	var method = 'POST';
				    	var url = baseUrl + '/selloCityWeb/customer/productBenefits/'+mappingId;
				    	return $http.post(url, fd, {
				            transformRequest: angular.identity,
				            headers: {'Content-Type': undefined}
				        }).then(this.successHandler, this.errorHandler);	
				    },
	};
	return angular.extend(service, BaseService);
});