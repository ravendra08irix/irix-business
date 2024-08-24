package com.irix.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

//	@PostMapping("/create")
//	public ResponseEntity<ClientsData> createUser(@RequestBody ClientsData clientsData) {
//		try {
//			ClientsData savedData = clientsDataService.createClient(clientsData);
//			return ResponseEntity.ok(savedData);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		}

//	}

	@PostMapping("/create")
	public ResponseEntity<ClientsData> createUser(@RequestParam("name") String name,
			@RequestParam("company") String company, @RequestParam("designation") String designation,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("website") String website,
			@RequestParam("industryType") String industryType,
			@RequestParam("otherIndustryType") String otherIndustryType, @RequestParam("interested") String interested,
			@RequestParam("otherInterested") String otherInterested, @RequestParam("photo") MultipartFile photo) {
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
			clientsData.setPhoto(photo.getBytes());

			ClientsData savedData = clientsDataService.createClient(clientsData);
			return ResponseEntity.ok(savedData);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
