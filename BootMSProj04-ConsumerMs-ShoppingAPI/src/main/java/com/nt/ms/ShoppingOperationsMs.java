package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceClient;


@RestController
@RequestMapping("/shopping-api")
public class ShoppingOperationsMs {
	@Autowired
	private IBillingServiceClient client;
	
	@Value("${db.user:system}")
	private String dbuser;
	@Value("${db.pwd:1234}")
	private String dbpwd;
	
	@GetMapping("/purchase")
	public ResponseEntity<String > doShopping(){
		System.out.println("ShoppingOperationsMs.doShopping()");
		
		ResponseEntity<String> resp=client.invokeDoBillingEndPoint();
		String resultMsg="dbuser="+dbuser+".."+"dbpwd="+dbpwd+"....shirt,trouser are purchased with the bill amount::"+resp.getBody();
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
	}

}
