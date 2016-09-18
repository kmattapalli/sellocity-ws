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
import com.sales.module.domain.ScSalesplay;
import com.sales.module.domain.ScSalesplayMapping;
import com.sales.module.service.CustomerService;


@Controller
@Transactional
public class CustomerController  extends AbstractRestController{
	
	 
    @Autowired
    private CustomerService customerService;
    
  


    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

 
    @RequestMapping(value = "/customer/salesplay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplay addScSalesplayData(@RequestParam("file") final MultipartFile productImage,@RequestParam("data") final String info) throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();

    	CustomerInfo infoData  = mapper.readValue(info,CustomerInfo.class);
    	File uploads = new File("/Users/qzdbxb/projects/uploads/Dell/"+productImage.getOriginalFilename());
    	FileUtils.writeByteArrayToFile(uploads, productImage.getBytes());
    	ScSalesplay salesPlay = customerService.createSalesPlay(infoData, "Dell","/Users/qzdbxb/projects/uploads/Dell/"+productImage.getOriginalFilename());
		return salesPlay;
    }
    @RequestMapping(value = "/customer/salesplay/{playId}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplay addPaintPoints(@PathVariable final Integer playId, @RequestBody SalesPlayMappingInfo mappingInfo)  {
    
    	return customerService.addSalesPlayMapping(mappingInfo,playId);
    	
    }
    @RequestMapping(value = "/customer/{salesPlayName}/productData/{mappingId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayMapping addPaintPoints1(@PathVariable final String salesPlayName,@PathVariable final Integer mappingId,@RequestParam("paintPoint")  MultipartFile paintPoint,
    		@RequestParam("productImage")  MultipartFile productImage,@RequestParam("productSpecs")  MultipartFile productSpecs,
    		@RequestParam("productManuals")  MultipartFile productManuals,@RequestParam("data") final String productInfo) throws IOException  {
    	
    	String pathName="/Users/qzdbxb/projects/uploads/Dell/"+salesPlayName+"/";
    	//File uploads = new File(pathName+paintPoint.getOriginalFilename());
    	FileUtils.writeByteArrayToFile(new File(pathName+paintPoint.getOriginalFilename()), paintPoint.getBytes());
    	FileUtils.writeByteArrayToFile(new File(pathName+productImage.getOriginalFilename()), productImage.getBytes());
    	FileUtils.writeByteArrayToFile(new File(pathName+productSpecs.getOriginalFilename()), productSpecs.getBytes());
    	FileUtils.writeByteArrayToFile(new File(pathName+productManuals.getOriginalFilename()), productManuals.getBytes());
    	return customerService.updateProductMapping(pathName+paintPoint.getOriginalFilename(),pathName+productImage.getOriginalFilename(),
    			pathName+productSpecs.getOriginalFilename(),pathName+productManuals.getOriginalFilename(),productInfo,mappingId);
    	
    }
    @RequestMapping(value = "/customer/getsalesplay/{playId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplay searchByIdWithMapping(@PathVariable final Integer playId)  {
    
    	ScSalesplay salesPlay= customerService.findBySalesPlayIdWithMapping(playId);
    	return salesPlay;
    	
    }
    @RequestMapping(value = "/customer/{salesPlayName}/productDetails/{mappingId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ScSalesplayMapping createProductData(@PathVariable final String salesPlayName,@PathVariable final Integer mappingId,@RequestParam("productAwards")  MultipartFile productAwards,
    		@RequestParam("productClaims")  MultipartFile productClaims,@RequestParam("productWhitePapers")  MultipartFile productWhitePapers,
    		@RequestParam("productTestimonials")  MultipartFile productTestimonials,@RequestParam("data") final String[] productData) throws IOException  {
    	
    	String pathName="/Users/qzdbxb/projects/uploads/Dell/"+salesPlayName+"/";
    	//File uploads = new File(pathName+paintPoint.getOriginalFilename());
    	FileUtils.writeByteArrayToFile(new File(pathName+productAwards.getOriginalFilename()), productAwards.getBytes());
    	FileUtils.writeByteArrayToFile(new File(pathName+productClaims.getOriginalFilename()), productClaims.getBytes());
    	FileUtils.writeByteArrayToFile(new File(pathName+productWhitePapers.getOriginalFilename()), productWhitePapers.getBytes());
    	FileUtils.writeByteArrayToFile(new File(pathName+productTestimonials.getOriginalFilename()), productTestimonials.getBytes());
    	return customerService.updateProductDetails(pathName+productAwards.getOriginalFilename(),pathName+productClaims.getOriginalFilename(),
    			pathName+productWhitePapers.getOriginalFilename(),pathName+productTestimonials.getOriginalFilename(),mappingId,productData);
    	
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
}

