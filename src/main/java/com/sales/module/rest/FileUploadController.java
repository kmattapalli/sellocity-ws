package com.sales.module.rest;

import java.sql.Blob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.sales.module.domain.FileUploadResponse;

@Controller
public class FileUploadController extends AbstractRestController {

//	@Autowired
//	private CustomerMainDAO customerDAO;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public FileUploadResponse uploadFile(@RequestParam("clientLogo") final MultipartFile productImage,@RequestParam(value = "clientName")String clientName,@RequestParam(value = "clientpain") String clientpain)	throws Exception {
		FileUploadResponse response = new FileUploadResponse();
		//CustomerProducts products= new CustomerProducts();
//		products.setCustId("10");
//		products.setProductId("BMW");
		Blob blob = new javax.sql.rowset.serial.SerialBlob(productImage.getBytes());
//		products.setProductImage(blob);
//		customerDAO.add(products);
		response.setFileName(productImage.getName());
		response.setStatusCode(1);
		response.setMessage("File Uploaded Successfully");
		return response;
	}

}
