package com.steven.prueba.alianza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.steven.prueba.alianza.model.Client;
import com.steven.prueba.alianza.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@Controller
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/getAllClients") // stereotype rest controller
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
	
	@PostMapping("/saveClient")
	public ResponseEntity<Client> saveClient(@RequestBody Client client) { // Crea o edita cliente
		Client clientCreated = clientService.saveClient(client);
		return new ResponseEntity<> (clientCreated, HttpStatus.CREATED);
	}
	
	@GetMapping("/getClientsByFilters") // stereotype rest controller
    public List<Client> getClientsByFilters(@RequestParam("value") String jsonString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		String sharedKey = jsonNode.get("sharedKey").asText();
		String email = jsonNode.get("email").asText();
		String name = jsonNode.get("name").asText();
		String phone = jsonNode.get("phone").asText();
        return clientService.getClientsByFilters(sharedKey, email, name, phone);
    }
	
}
