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
import com.sales.module.domain.ScProductView;
import com.sales.module.domain.ScSalesplay;
import com.sales.module.domain.ScSalesplayAward;
import com.sales.module.domain.ScSalesplayBenefit;
import com.sales.module.domain.ScSalesplayClaim;
import com.sales.module.domain.ScSalesplayManual;
import com.sales.module.domain.ScSalesplayMapping;
import com.sales.module.domain.ScSalesplaySpec;
import com.sales.module.domain.ScSalesplayTestimonial;
import com.sales.module.domain.ScSalesplayValue;
import com.sales.module.domain.ScSalesplayView;
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
		ScUser user = userDao.findBySuid(1);

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
	public ScSalesplayView createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath){
		
		if(customerInfo.getSpid() == null){
			ScClient clients = new ScClient();
			clients.setCountry("USA");
			ScCustomer cust = createCustomer();
			clients.setScCustomer(cust);
			clients.setLogo(imagePath);
			clients.setName(customerInfo.getClientName());
			clients = clientDao.persist(clients);
			
			ScStatus status =statusDao.findScStatusByName("A");
			
			ScSalesplay salesPlay =new ScSalesplay();
			salesPlay.setScCustomer(cust);
			salesPlay.setScUser1(createUser());
			salesPlay.setScClient(clients);
			salesPlay.setCustImage(imagePath);
			salesPlay.setClientName(customerInfo.getClientName());
			salesPlay.setClientContactName(customerInfo.getCustomerClientContact());
			salesPlay.setClientContactEmail(customerInfo.getCustomerClientEmail());
			salesPlay.setName(customerInfo.getSalesPlayName());
			salesPlay.setScStatus(status);
			salesPlay = salesPlayDao.persist(salesPlay);

			return mapSalesPlayView(salesPlay);
			}else{
				ScSalesplay salesPlay = salesPlayDao.findByScSalesplayId(customerInfo.getSpid());
				salesPlay.setSpid(customerInfo.getSpid());
				salesPlay.setClientName(customerInfo.getClientName());
				salesPlay.setClientContactName(customerInfo.getCustomerClientContact());
				salesPlay.setClientContactEmail(customerInfo.getCustomerClientEmail());
				salesPlay.setName(customerInfo.getSalesPlayName());
				if(imagePath != null){
					salesPlay.getScClient().setLogo(imagePath);
				}
				salesPlay = salesPlayDao.update(salesPlay);
				return mapSalesPlayView(salesPlay);
			
			}
	

		
		
	}
	public ScSalesplayView getSalesPlayData(Integer salesPlayId){
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayId(salesPlayId);

		return mapSalesPlayView(salesPlay);
	}
	public ScSalesplayView mapSalesPlayView(ScSalesplay salesPlay){
		ScSalesplayView view = new ScSalesplayView();
		view.setSpid(salesPlay.getSpid());
		view.setClientName(salesPlay.getClientName());
		view.setCustomerClientContact(salesPlay.getClientContactName());
		view.setCustomerClientEmail(salesPlay.getClientContactEmail());
		view.setSalesPlayName(salesPlay.getName());
		if(salesPlay.getScClient().getLogo() != null){
			String fileName= salesPlay.getScClient().getLogo() ;
			
			//fileName =fileName.substring(fileName.lastIndexOf("/")+1);
			view.setClientLogo(fileName);
		}
		return view;
	}
	public ScSalesplay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId){
		
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayId(salesPlayId);
		List<ScSalesplayMapping> mappingList = new ArrayList<ScSalesplayMapping>();
		if(mappingInfo.getPainPoint1() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint1(), mappingInfo.getSpmapId1(),salesPlay));
		}
		if(mappingInfo.getPainPoint2() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint2(),mappingInfo.getSpmapId2(), salesPlay));
		}
		if(mappingInfo.getPainPoint3() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint3(),mappingInfo.getSpmapId3(), salesPlay));
		}
		if(mappingInfo.getPainPoint4() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint4(), mappingInfo.getSpmapId4(),salesPlay));
		}
		salesPlay.setScSalesplayMappings(mappingList);
		return salesPlay;
	}
	private ScSalesplayMapping createSalesMapping(String  paingPoint, Integer spmapId, ScSalesplay salesPlay) {
		ScSalesplayMapping salesPlayMapping  = new ScSalesplayMapping();
		salesPlayMapping.setPainPoint(paingPoint);
		salesPlayMapping.setProductName(paingPoint);
		salesPlayMapping.setScSalesplay(salesPlay);
		salesPlayMapping.setScStatus(salesPlay.getScStatus());
		if(spmapId != null){
			salesPlayMapping.setSpmapId(spmapId);
			salesPlayMappingDao.update(salesPlayMapping);
		}else{
			salesPlayMappingDao.persist(salesPlayMapping);
			}
		return salesPlayMapping;
	}
	public ScSalesplayView findBySalesPlayProductsInfo(Integer salesId){
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayIdWithMapping(salesId);
		ScSalesplayView scSalesplayView = mapSalesPlayView(salesPlay);
		List<ScProductView> views= new ArrayList<ScProductView>();
		for(ScSalesplayMapping mapping:salesPlay.getScSalesplayMappings()){
			ScProductView productObj = new ScProductView();
			productObj.setPainPoint(mapping.getPainPoint());
			productObj.setSpmapId(mapping.getSpmapId());
			productObj.setProductInfo(mapping.getProductInfo());
			productObj.setProductImage(filterImage(mapping.getProductImage()));
			productObj.setPainPointImage(filterImage(mapping.getPainPointImage()));
			ScSalesplayManual manuals = salesPlayManualDAO.findByScSalesplayManuals(mapping.getSpmapId());
			if(manuals !=null){
				productObj.setProductManuals(filterImage(manuals.getUrl()));
				productObj.setManualId(manuals.getManualId());
			}
			ScSalesplaySpec specs = salesPlaySpecsDAO.findByScSalesplaySpecId(mapping.getSpmapId());
			if(specs != null){
				productObj.setSpecId(specs.getSpecId());
				productObj.setProductSpecs(filterImage(specs.getUrl()));
			}
			views.add(productObj);
			
		}
		scSalesplayView.setScSalesplayMappings(views);
		return scSalesplayView;
	}	
	private String filterImage(String fileName){
		if(fileName != null && fileName.length()>0){
			fileName =fileName.substring(fileName.lastIndexOf("/")+1);
		}
		return fileName;
	}
	public ScSalesplayMapping updateProductMapping(String  paingPointURl,String productURL,String specsURL,String manualURL,
			ScProductView productView,Integer mappingId,String productInStock ) {
		ScSalesplayMapping salesPlayMapping = salesPlayMappingDao.findByScSalesplayMappingId(mappingId);
		if(paingPointURl != null)
			salesPlayMapping.setPainPointImage(paingPointURl);
		if(productInStock == null || "undefined".equalsIgnoreCase(productInStock)){
			salesPlayMapping.setProductInStock("N");
		}else{
			salesPlayMapping.setProductInStock(productInStock.trim());
		}
		if(productURL != null)
		salesPlayMapping.setProductImage(productURL);
		salesPlayMapping.setProductInfo(productView.getProductInfo());
		salesPlayMapping.setProductName(productView.getProductInfo());
		salesPlayMappingDao.update(salesPlayMapping);
		if(manualURL != null && manualURL.length()>0){
			ScSalesplayManual manuals = new ScSalesplayManual();

			manuals.setUrl(manualURL);
			manuals.setScSalesplayMapping(salesPlayMapping);
			if(productView.getManualId() != null){
				manuals.setManualId(productView.getManualId());
				salesPlayManualDAO.update(manuals);
			}else{
				salesPlayManualDAO.persist(manuals);
			}
		}
		if(specsURL != null && specsURL.length()>0){
			ScSalesplaySpec specs = new ScSalesplaySpec();
			
			specs.setUrl(specsURL);
			specs.setScSalesplayMapping(salesPlayMapping);
			if(productView.getSpecId() != null){
				specs.setSpecId(productView.getSpecId());
				salesPlaySpecsDAO.update(specs);
			}else{
				salesPlaySpecsDAO.persist(specs);
			}
		}

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
	testimonials.setImageUrl(testimonialURL);
	testimonials.setScSalesplayMapping(salesPlayMapping);
	salesPlayTestimonialsDAO.persist(testimonials);	
	
	return salesPlayMapping;
	}	

	
	public ScSalesplay findBySalesPlayIdWithMapping(Integer salesId){
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayIdWithMapping(salesId);
		return salesPlay;
	}
	public SalesPlayMappingInfo getPaintPointDataForSalesPlay(Integer salesId){
		SalesPlayMappingInfo mappingInfo = new SalesPlayMappingInfo();
		ScSalesplay salesPlay = salesPlayDao.findByScSalesplayIdWithMapping(salesId);
		if(salesPlay.getScSalesplayMappings() != null){
			int count =1;
			for(ScSalesplayMapping mapping: salesPlay.getScSalesplayMappings()){
				if(count ==1){
					mappingInfo.setPainPoint1(mapping.getPainPoint());
					mappingInfo.setSpmapId1(mapping.getSpmapId());
				}
				if(count ==2){
					mappingInfo.setPainPoint2(mapping.getPainPoint());
					mappingInfo.setSpmapId2(mapping.getSpmapId());
				}
				if(count ==3){
					mappingInfo.setPainPoint3(mapping.getPainPoint());
					mappingInfo.setSpmapId3(mapping.getSpmapId());
				}
				if(count ==4){
					mappingInfo.setPainPoint4(mapping.getPainPoint());
					mappingInfo.setSpmapId4(mapping.getSpmapId());
				}	
				count=count+1;
			}
		}
		return mappingInfo;
		
	}
	public ScSalesplayMapping findBySalesPlayMappingWithBenefits(Integer mappingId){
		return salesPlayMappingDao.findByScSalesplayMappingWithBenefits(mappingId);
	}

}
