package com.steven.prueba.alianza.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.steven.prueba.alianza.model.Client;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties") // classpath -> src/test/resources
public class ClientRepositoryTests {

	@Autowired
	private ClientRepository clientRepository;
	
	@Test
	void testSaveClient() {
		//before
		Client client1 = new Client();
		client1.setName("Steven");
		client1.setEmail("steven@gmail.com");
		client1.setSharedKey("steven");
		client1.setCreationDate("2023/04/01 14:39:15");
		client1.setPhone("3132224444");
		//action
		Client clientSaved = clientRepository.save(client1);
		//asserts
		assertThat(clientSaved).isNotNull();
		assertThat(clientSaved.getId()).isGreaterThan(0);
	}
	
	@Test
	void testGetClients() {
		//before
		List<Client> clients1 = clientRepository.searchClientsByFilters("steven");
		assertThat(clients1.size()).isEqualTo(0);
		//after
		Client client1 = new Client();
		client1.setName("Steven");
		client1.setEmail("steven@gmail.com");
		client1.setSharedKey("steven");
		client1.setCreationDate("2023/04/01 14:39:15");
		client1.setPhone("3132224444");
		
		Client client2 = new Client();
		client2.setName("Carolina");
		client2.setEmail("carolina@gmail.com");
		client2.setSharedKey("carolina");
		client2.setCreationDate("2023/03/01 14:39:15");
		client2.setPhone("3132224445");
		
		clientRepository.save(client1);
		clientRepository.save(client2);
		
		List<Client> clients2 = clientRepository.searchClientsByFilters("st");
		List<Client> clients3 = (List<Client>) clientRepository.findAll();
		assertThat(clients2.size()).isEqualTo(1);
		assertThat(clients3.size()).isGreaterThan(1);

	}
}
