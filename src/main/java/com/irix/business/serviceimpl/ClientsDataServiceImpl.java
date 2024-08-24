package com.irix.business.serviceimpl;

import com.irix.business.entity.ClientsData;
import com.irix.business.repository.ClientDataRepository;
import com.irix.business.service.ClientsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsDataServiceImpl implements ClientsDataService {

	@Autowired
	private ClientDataRepository clientDataRepository;

	@Override
	public ClientsData createClient(ClientsData clientsData) {
		return clientDataRepository.save(clientsData);
	}
}
