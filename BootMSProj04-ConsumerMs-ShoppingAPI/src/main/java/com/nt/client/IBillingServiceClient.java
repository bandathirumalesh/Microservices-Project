package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("Billing-Ms")
public interface IBillingServiceClient {
     @GetMapping("/BillingMs/billing-api/show-amt")
	 public ResponseEntity<String> invokeDoBillingEndPoint();
	 

}
