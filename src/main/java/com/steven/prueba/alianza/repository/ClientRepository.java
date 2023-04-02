package com.steven.prueba.alianza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.steven.prueba.alianza.model.Client;


@Repository
@Transactional
@EnableTransactionManagement
public interface ClientRepository extends CrudRepository<Client,Integer>{

	public List<Client> findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase (String name, String email);
	
	@Query("SELECT c FROM Client c WHERE c.sharedKey like %:sharedKey% ORDER BY c.id DESC")
    List<Client> searchClientsByFilters(@Param("sharedKey") String sharedKey);
}
