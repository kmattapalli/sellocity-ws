package com.sales.module.rest;

import java.io.File;
import java.io.IOException;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlayMappingInfo;
import com.sales.module.domain.ScProductView;
import com.sales.module.domain.ScSalesplay;
import com.sales.module.domain.ScSalesplayMapping;
import com.sales.module.domain.ScSalesplayView;
import com.sales.module.service.CustomerService;


@Controller
@Transactional
public class CustomerController  extends AbstractRestController{
	
	//final static String fileNamePath= System.getProperty("catalina.base");
	//final static String fileNamePath= "/site/wwwroot/webapps/";
	final static String fileNamePath= "D:\\home\\site\\wwwroot\\webapps\\images\\";
	final static String urlPath="http://mala-ws.azurewebsites.net/images/";
	
	static String salesPerson="TestUser";
	final static String pathName=fileNamePath;
	
    @Autowired
    private CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

 
    @RequestMapping(value = "/customer/salesplay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayView addScSalesplayData(@RequestParam(value="file",required=false) final MultipartFile productImage,@RequestParam("data") final String info) throws JsonParseException, JsonMappingException, IOException {
  
    	ObjectMapper mapper = new ObjectMapper();
    	String fileUrl=null;
    	CustomerInfo infoData  = mapper.readValue(info,CustomerInfo.class);
    	if(productImage != null){
    		File uploads = new File(pathName+productImage.getOriginalFilename());
    		FileUtils.writeByteArrayToFile(uploads, productImage.getBytes());
    		fileUrl=fileNamePath+productImage.getOriginalFilename();
    	}
    	ScSalesplayView salesPlay = customerService.createSalesPlay(infoData, "Dell",urlPath+productImage.getOriginalFilename());
		return salesPlay;
    }
    @RequestMapping(value = "/customer/salesplay/{playId}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplay addPaintPoints(@PathVariable final Integer playId, @RequestBody SalesPlayMappingInfo mappingInfo)  {
    
    	return customerService.addSalesPlayMapping(mappingInfo,playId);
    	
    }
    @RequestMapping(value = "/customer/productData/{mappingId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayMapping addProductInfo(@PathVariable final Integer mappingId,
    		@RequestParam(value="paintPoint",required=false)  MultipartFile paintPoint,
    		@RequestParam(value="productImage",required=false)  MultipartFile productImage,@RequestParam(value="productSpecs",required=false)  MultipartFile productSpecs,
    		@RequestParam(value="productManuals",required=false)  MultipartFile productManuals,@RequestParam("data") final String data,
    		@RequestParam(value="specId",required=false) final String specId,@RequestParam(value="manualId",required=false) final String manualId,
    		@RequestParam(value="productInStock",required=false) final String productInStock ) throws IOException  {
    	
 
    	ScProductView infoData  = new ScProductView();
    	infoData.setProductInfo(data);
    	if(manualId != null&& !manualId.equals("null")){
    		infoData.setManualId(Integer.parseInt(manualId));
    	}
      	if(specId != null&& !specId.equals("null")){
    		infoData.setSpecId(Integer.parseInt(specId));
    	}
    	
    	String paintPointInfo		= 		createFileData(pathName,paintPoint);
    	String productImageInfo	=	createFileData(pathName,productImage);
    	String productSpecsInfo	=	createFileData(pathName,productSpecs);
    	String productManualsInfo		=		createFileData(pathName,productManuals);

    	return customerService.updateProductMapping(paintPointInfo,productImageInfo,productSpecsInfo,productManualsInfo,infoData,mappingId,productInStock);
    	
    }
    @RequestMapping(value = "/customer/getsalesplay/paintpoints/{playId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SalesPlayMappingInfo getPainpointsData(@PathVariable final Integer playId)  {
    
    	SalesPlayMappingInfo salesPlay= customerService.getPaintPointDataForSalesPlay(playId);
    	return salesPlay;
    	
    }
    @RequestMapping(value = "/customer/getsalesplay/{playId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplay searchByIdWithMapping(@PathVariable final Integer playId)  {
    
    	ScSalesplay salesPlay= customerService.findBySalesPlayIdWithMapping(playId);
    	return salesPlay;
    	
    }
    @RequestMapping(value = "/customer/getsalesplay/products/{playId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayView getSalesPlayProductData(@PathVariable final Integer playId)  {
    
    	ScSalesplayView salesPlay= customerService.findBySalesPlayProductsInfo(playId);
    	return salesPlay;
    	
    }
    @RequestMapping(value = "/customer/salesplay/getsalesplay/{playId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayView getSalesPlayData(@PathVariable final Integer playId)  {
    
    	ScSalesplayView salesPlay= customerService.getSalesPlayData(playId);
    	return salesPlay;
    	
    }
    @RequestMapping(value = "/customer/{salesPlayName}/productDetails/{mappingId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayMapping createProductData(@PathVariable final String salesPlayName,@PathVariable final Integer mappingId,@RequestParam(value="productAwards",required=false)  MultipartFile productAwards,
    		@RequestParam(value="productClaims",required=false)  MultipartFile productClaims,@RequestParam(value="productWhitePapers",required=false)  MultipartFile productWhitePapers,
    		@RequestParam(value="productTestimonials",required=false)  MultipartFile productTestimonials,@RequestParam("data") final String[] productData) throws IOException  {
    	
    

    	String productClaimsInfo		= 		createFileData(pathName,productClaims);
    	String productWhitePapersInfo	=	createFileData(pathName,productWhitePapers);
    	String productTestimonialsInfo	=	createFileData(pathName,productTestimonials);
    	String productAwardsInfo		=		createFileData(pathName,productAwards);
   
    	return customerService.updateProductDetails(productAwardsInfo,productClaimsInfo,productWhitePapersInfo,productTestimonialsInfo,mappingId,productData);
    	
    }
    @RequestMapping(value = "/customer/productBenefits/{mappingId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayMapping createProductBenefits(@PathVariable final Integer mappingId,@RequestParam("benefitsData") final String[] benefitsData) throws IOException  {

    	return customerService.updateProductBenefits(mappingId,benefitsData);

    }
    @RequestMapping(value = "/customer/salesplaymapping/benefits/{spmapId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayMapping getMappingDetails(@PathVariable final Integer spmapId)  {
    
    	ScSalesplayMapping mappingObj= customerService.findBySalesPlayMappingWithBenefits(spmapId);
    	
    	return mappingObj;
    } 
    private String createFileData(String filePath,MultipartFile fileData) throws IOException{
    	
    	if(fileData != null){
    		FileUtils.writeByteArrayToFile(new File(filePath+fileData.getOriginalFilename()), fileData.getBytes());
    		return urlPath+fileData.getOriginalFilename();
    	}
    	return null;
    	
    }
}

