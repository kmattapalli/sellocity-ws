tracker.factory("UploadFileService", function($http){
	
 //Placeholder for import file service
	return {
		isAnUpload: function(uploadName) {			
			return (uploadName.indexOf('upload') == 0);
		},
		
		
		isAllEntityUpload: function(uploadName) {
			if(uploadName == 'uploadFile') {
				return true;
			}
			return false;
		},
	};
	
});