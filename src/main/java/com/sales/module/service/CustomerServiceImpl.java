package com.sales.module.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.module.dao.ClientDAO;
import com.sales.module.dao.CustomerDAO;
import com.sales.module.dao.SalesPlayAwardsDAO;
import com.sales.module.dao.SalesPlayBenefitDAO;
import com.sales.module.dao.SalesPlayClaimsDAO;
import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.dao.SalesPlayManualsDAO;
import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.dao.SalesPlaySpecsDAO;
import com.sales.module.dao.SalesPlayTestimonialsDAO;
import com.sales.module.dao.SalesPlayValuesDAO;
import com.sales.module.dao.StatusDAO;
import com.sales.module.dao.UserDAO;
import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlayMappingInfo;
import com.sales.module.domain.ScClient;
import com.sales.module.domain.ScCustomer;
import com.sales.module.domain.ScSalesplay;
import com.sales.module.domain.ScSalesplayAward;
import com.sales.module.domain.ScSalesplayBenefit;
import com.sales.module.domain.ScSalesplayClaim;
import com.sales.module.domain.ScSalesplayManual;
import com.sales.module.domain.ScSalesplayMapping;
import com.sales.module.domain.ScSalesplaySpec;
import com.sales.module.domain.ScSalesplayTestimonial;
import com.sales.module.domain.ScSalesplayValue;
import com.sales.module.domain.ScStatus;
import com.sales.module.domain.ScUser;

@Service
public class CustomerServiceImpl implements CustomerService {


	
	@Autowired
	StatusDAO<ScStatus> statusDao;
	
	@Autowired
	UserDAO<ScUser> userDao;
	
	@Autowired
	ClientDAO<ScClient> clientDao;

	@Autowired
	CustomerDAO<ScCustomer> customerDao;
	
//	@Autowired
//	SalesPersonDAO<SalesPerson> salesPerson;
//	
	@Autowired
	SalesPlayDAO<ScSalesplay> salesPlayDao;
	
	@Autowired
	SalesPlayMappingDAO<ScSalesplayMapping> salesPlayMappingDao;
	
	@Autowired
	SalesPlayManualsDAO<ScSalesplayManual> salesPlayManualDAO;
	
	@Autowired
	SalesPlaySpecsDAO<ScSalesplaySpec> salesPlaySpecsDAO;
	
	@Autowired
	SalesPlayValuesDAO<ScSalesplayValue> salesPlayValuesDAO;
	
	@Autowired
	SalesPlayBenefitDAO<ScSalesplayBenefit> salesPlayBenefitDAO;
	
	@Autowired
	SalesPlayTestimonialsDAO<ScSalesplayTestimonial> salesPlayTestimonialsDAO;
	
	@Autowired
	SalesPlayAwardsDAO<ScSalesplayAward> salesPlayAwardsDAO;

	@Autowired
	SalesPlayClaimsDAO<ScSalesplayClaim> salesPlayClaimsDAO;
	

	
	public ScStatus createStatus(){
		List<ScStatus> statusList = statusDao.findAll();
		ScStatus status = new ScStatus();
		if(statusList != null && statusList.size()>0){
			status = statusList.get(0);
		}
		return status;
		
	}
	public ScUser createUser(){
		List<ScUser> userList = userDao.findAll();
		ScUser user = new ScUser();
		if(userList != null && userList.size()>0){
			user = userList.get(0);
		}
		return user;
		
	}	
	public ScCustomer createCustomer(){
		List<ScCustomer> customerList = customerDao.findAll();
		
		ScCustomer customer = new ScCustomer();
		if(customerList != null && customerList.size()>0){
			customer = customerList.get(0);
		}
		return customer;
		
	}	
	public ScSalesplay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath){
		
		//List<ScSalesplayMapping> salesPlayMappingList = new ArrayList<ScSalesplayMapping>();
		ScClient clients = new ScClient();
		clients.setCountry("USA");
		ScCustomer cust = createCustomer();
		clients.setScCustomer(cust);
		clients.setLogo(imagePath);
		clients.setName(customerInfo.getClientName());
		clients = clientDao.persist(clients);

		
		ScSalesplay salesPlay =new ScSalesplay();
		salesPlay.setScCustomer(cust);
		salesPlay.setScUser1(createUser());
		salesPlay.setScClient(clients);
		salesPlay.setClientContactName(customerInfo.getCustomerClientContact());
		salesPlay.setClientContactEmail(customerInfo.getCustomerClientEmail());
		salesPlay.setName(customerInfo.getSalesPlayName());
		salesPlay = salesPlayDao.persist(salesPlay);
//		
//		if(customerInfo.getPainPoint1() != null){
//			ScSalesplayMapping mapping = new ScSalesplayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint1() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
//		if(customerInfo.getPainPoint2() != null){
//			ScSalesplayMapping mapping = new ScSalesplayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint2() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
//		if(customerInfo.getPainPoint3() != null){
//			ScSalesplayMapping mapping = new ScSalesplayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint3() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
//		if(customerInfo.getPainPoint4() != null){
//			ScSalesplayMapping mapping = new ScSalesplayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint4() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
		//salesPlay.setSalesPlayMapping(salesPlayMappingList);
		return salesPlay;	
		
	}
	public ScSalesplay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId){
		
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayId(salesPlayId);
		List<ScSalesplayMapping> mappingList = new ArrayList<ScSalesplayMapping>();
		if(mappingInfo.getPainPoint1() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint1(), salesPlay));
		}
		if(mappingInfo.getPainPoint2() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint2(), salesPlay));
		}
		if(mappingInfo.getPainPoint3() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint3(), salesPlay));
		}
		if(mappingInfo.getPainPoint4() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint4(), salesPlay));
		}
		salesPlay.setScSalesplayMappings(mappingList);
		return salesPlay;
	}
	private ScSalesplayMapping createSalesMapping(String  paingPoint, ScSalesplay salesPlay) {
		ScSalesplayMapping salesPlayMapping  = new ScSalesplayMapping();
		salesPlayMapping.setPainPoint(paingPoint);
		salesPlayMapping.setScSalesplay(salesPlay);
		salesPlayMapping.setScStatus(salesPlay.getScStatus());
		salesPlayMappingDao.persist(salesPlayMapping);
		return salesPlayMapping;
	}
	public ScSalesplayMapping updateProductMapping(String  paingPointURl,String productURL,String specsURL,String manualURL,
				String productInfo,Integer mappingId ) {
		ScSalesplayMapping salesPlayMapping = salesPlayMappingDao.findByScSalesplayMappingId(mappingId);
		salesPlayMapping.setPainPointImage(paingPointURl);
		salesPlayMapping.setProductImage(productURL);
		salesPlayMapping.setProductInfo(productInfo);
		salesPlayMappingDao.update(salesPlayMapping);
		ScSalesplayManual manuals = new ScSalesplayManual();
		manuals.setName(productInfo);
		manuals.setUrl(manualURL);
		salesPlayManualDAO.persist(manuals);
		ScSalesplaySpec specs = new ScSalesplaySpec();
		specs.setName(productInfo);
		specs.setUrl(specsURL);
		salesPlaySpecsDAO.persist(specs);

		return salesPlayMapping;
	}
	public ScSalesplayMapping updateProductBenefits(Integer mappingId,String[] benefitsValues ){
		ScSalesplayMapping salesPlayMapping = salesPlayMappingDao.findByScSalesplayMappingId(mappingId);
		for(String benefit:benefitsValues){
			ScSalesplayBenefit value = new ScSalesplayBenefit();
			value.setScSalesplayMapping(salesPlayMapping);
			value.setBenefit(benefit);
			salesPlayBenefitDAO.persist(value);
		}
		return salesPlayMapping;
	}
	public ScSalesplayMapping updateProductDetails(String  awardsURl,String claimsURL,String whitePapersURL,String testimonialURL,
			Integer mappingId,String[] productValues ) {
	ScSalesplayMapping salesPlayMapping = salesPlayMappingDao.findByScSalesplayMappingId(mappingId);

	for(String prodValue:productValues){
		ScSalesplayValue value = new ScSalesplayValue();
		value.setScSalesplayMapping(salesPlayMapping);
		value.setValue(prodValue);
		salesPlayValuesDAO.persist(value);
		
	}
	
	ScSalesplayAward awards = new ScSalesplayAward();
	awards.setImageUrl(awardsURl);
	awards.setScSalesplayMapping(salesPlayMapping);
	salesPlayAwardsDAO.persist(awards);

	ScSalesplayClaim claims = new ScSalesplayClaim();
	claims.setImageUrl(claimsURL);
	claims.setScSalesplayMapping(salesPlayMapping);
	salesPlayClaimsDAO.persist(claims);	

	ScSalesplayTestimonial testimonials = new ScSalesplayTestimonial();
	testimonials.setImageUrl(claimsURL);
	testimonials.setScSalesplayMapping(salesPlayMapping);
	salesPlayTestimonialsDAO.persist(testimonials);	
	
	return salesPlayMapping;
	}	
	
	
	public ScSalesplay findBySalesPlayIdWithMapping(Integer salesId){
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayIdWithMapping(salesId);
//		List<ScSalesplayMapping> mapping = salesPlayMappingDao.findByScSalesplayMappingList(salesPlay.getSpid());
//		salesPlay.setScSalesplayMappings(mapping);
		return salesPlay;
	}
	public ScSalesplayMapping findBySalesPlayMappingWithBenefits(Integer mappingId){
		return salesPlayMappingDao.findByScSalesplayMappingWithBenefits(mappingId);
	}

}
