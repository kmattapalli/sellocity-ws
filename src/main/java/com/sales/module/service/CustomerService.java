package com.sales.module.service;

import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.ProductValues;
import com.sales.module.domain.SalesPlayMappingInfo;
import com.sales.module.domain.ScSalesplay;
import com.sales.module.domain.ScSalesplayMapping;

public interface CustomerService {

	public ScSalesplay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath);
	
	public ScSalesplay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId);
	
	public ScSalesplayMapping updateProductMapping(String  paingPointURl,String productURL,String specsURL,String manualURL,
			String productInfo,Integer mappingId ) ;
  
	public ScSalesplay findBySalesPlayIdWithMapping(Integer salesId);
	
	public ScSalesplayMapping updateProductDetails(String  awardsURl,String claimsURL,String whitePapersURL,String testimonialURL,
			Integer mappingId,ProductValues productValues );
	public ScSalesplayMapping findBySalesPlayMappingWithBenefits(Integer mappingId);
}
