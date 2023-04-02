package com.steven.prueba.alianza.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.prueba.alianza.model.Client;
import com.steven.prueba.alianza.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients () {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		return clients;
	}
	
	public Client saveClient (Client client) {
		Client clientSaved = new Client();
		clientSaved.setId(client.getId());
		clientSaved.setName(client.getName());
		clientSaved.setEmail(client.getEmail());
		clientSaved.setPhone(client.getPhone());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		clientSaved.setCreationDate(dtf.format(now));
		String sharedKey = client.getEmail().split("@")[0];
		clientSaved.setSharedKey(sharedKey);
		clientRepository.save(clientSaved);
		return clientSaved;
	}
	
	public List<Client> getClientsByFilters (String sharedKey) {
		List<Client> clients = clientRepository.searchClientsByFilters(sharedKey);
		return clients;
	}
}
