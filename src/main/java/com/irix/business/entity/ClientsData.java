package com.irix.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class ClientsData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String company;
	private String designation;
	private String phoneNumber;
	private String website;
	private String industryType;
	private String otherIndustryType;
	private String interested;
	private String otherInterested;

//	@Lob
//	private byte[] photo;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] photo;

}
