package com.irix.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.irix.business.entity.ClientsData;
import com.irix.business.service.ClientsDataService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClientsDataController {

	@Autowired
	private ClientsDataService clientsDataService;


	
	
	@GetMapping("/test")
	public String test() {
		return "Application Working";
	}

	@PostMapping("/create")
	public ResponseEntity<ClientsData> createUser(
	        @RequestParam(value = "name", required = false) String name,
	        @RequestParam(value = "company", required = false) String company,
	        @RequestParam(value = "designation", required = false) String designation,
	        @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
	        @RequestParam(value = "website", required = false) String website,
	        @RequestParam(value = "industryType", required = false) String industryType,
	        @RequestParam(value = "otherIndustryType", required = false) String otherIndustryType,
	        @RequestParam(value = "interested", required = false) String interested,
	        @RequestParam(value = "otherInterested", required = false) String otherInterested,
	        @RequestParam(value = "photo", required = false) MultipartFile photo) {
	    try {
	        ClientsData clientsData = new ClientsData();
	        clientsData.setName(name);
	        clientsData.setCompany(company);
	        clientsData.setDesignation(designation);
	        clientsData.setPhoneNumber(phoneNumber);
	        clientsData.setWebsite(website);
	        clientsData.setIndustryType(industryType);
	        clientsData.setOtherIndustryType(otherIndustryType);
	        clientsData.setInterested(interested);
	        clientsData.setOtherInterested(otherInterested);
	        if (photo != null) {
	            clientsData.setPhoto(photo.getBytes());
	        }

	        ClientsData savedData = clientsDataService.createClient(clientsData);
	        return ResponseEntity.ok(savedData);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}

}
