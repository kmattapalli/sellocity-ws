package com.sales.module.service;

import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlayMappingInfo;
import com.sales.module.domain.ScProductView;
import com.sales.module.domain.ScSalesplay;
import com.sales.module.domain.ScSalesplayMapping;
import com.sales.module.domain.ScSalesplayView;

public interface CustomerService {

	public ScSalesplayView createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath);
	
	public ScSalesplay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId);
	
	public ScSalesplayMapping updateProductMapping(String  paingPointURl,String productURL,String specsURL,String manualURL,
			ScProductView productView,Integer mappingId,String productInStock );
  
	public ScSalesplay findBySalesPlayIdWithMapping(Integer salesId);
	
	public ScSalesplayMapping updateProductDetails(String  awardsURl,String claimsURL,String whitePapersURL,String testimonialURL,
			Integer mappingId,String[] productValues );
	public ScSalesplayMapping updateProductBenefits(Integer mappingId,String[] benefitsValues );
	public ScSalesplayMapping findBySalesPlayMappingWithBenefits(Integer mappingId);
	public SalesPlayMappingInfo getPaintPointDataForSalesPlay(Integer salesId);
	public ScSalesplayView getSalesPlayData(Integer salesPlayId);
	public ScSalesplayView findBySalesPlayProductsInfo(Integer salesId);
}
