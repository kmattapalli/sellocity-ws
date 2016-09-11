tracker.controller('UploadFileController',['$scope','$state', 'UploadFileService','fileUpload',
    function($scope, $state, UploadFileService, fileUpload) {
	 var S = $scope;
	 var uploadService = UploadFileService;
	 S.activeLink = $state.$current.self.name;

	 S.formatTypeDisabled = false;
	 
	 S.clientName="";
	 S.clientpain="";

     S.savingIndicator = false;

	 S.isActiveLink = function(link){
		return  S.activeLink.indexOf(link) == 0; 
	 };
	 	
		S.errors = {};
		S.options = {
					
	                url: baseUrl + 'uploadFile'+'?clientName='+S.clientName+'&clientpain='+S.clientpain,
	                add: function (e, data) {
	                	//reset queue since this is a single file upload
	                    data.scope().queue =[];
	                    fileUpload.defaults.add(e, data);
	                },
	                submit: function(e, data) {
	                	
	                	  S.savingIndicator = true;
	                	  return true;

	                },
	                handleResponse: function (e, data) {
	                	if (data.errorThrown || data.textStatus === 'error') {
                            S.savingIndicator = false;
		            	   var message = data.result ? " - " + data.result.messages['applicationErrors'] : " upload error";  
		            	   S.errors[0] = (data.errorThrown || data.textStatus) + message;
	                	} else {
                            S.savingIndicator = true;
	                		S.fileUploadResponse = data.result;
	                		$state.transitionTo("successUpload");
	                	
                    	}
	                }
		};
		
		S.resetErrors = function() {
			S.errors = {};
		};
	}
]);

	