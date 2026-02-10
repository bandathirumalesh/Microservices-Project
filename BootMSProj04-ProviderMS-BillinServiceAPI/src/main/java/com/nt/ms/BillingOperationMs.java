package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationMs {
	
	
	
	@Value("${dbuser:system}")
	private String dbuser;
	@Value("${dbpwd:1234}")
	private String dbpwd;
	
	@GetMapping("/show-amt")
	public ResponseEntity<String>doBilling(){
		int billAmt=new Random().nextInt(20000);
		return new ResponseEntity<String>("Bill  Amount  is::"+billAmt+"db user="+dbuser+"dbpwd="+dbpwd,HttpStatus.OK);
	}

}
