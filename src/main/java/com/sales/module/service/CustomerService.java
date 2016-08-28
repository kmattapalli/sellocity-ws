package com.sales.module.service;

import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.ProductValues;
import com.sales.module.domain.SalesPlay;
import com.sales.module.domain.SalesPlayMapping;
import com.sales.module.domain.SalesPlayMappingInfo;

public interface CustomerService {

	public SalesPlay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath);
	
	public SalesPlay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId);
	
	public SalesPlayMapping updateProductMapping(String  paingPointURl,String productURL,String specsURL,String manualURL,
			String productInfo,Long mappingId ) ;
  
	public SalesPlay findBySalesPlayIdWithMapping(Integer salesId);
	
	public SalesPlayMapping updateProductDetails(String  awardsURl,String claimsURL,String whitePapersURL,String testimonialURL,
			Long mappingId,ProductValues productValues );
}
