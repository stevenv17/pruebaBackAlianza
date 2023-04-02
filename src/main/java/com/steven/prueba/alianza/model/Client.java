package com.steven.prueba.alianza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="CLIENTS")
public class Client {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(max=64, message = "Name field max size is 64")
	@Column(name="name")
	private String name;

	@NotBlank(message = "Email is mandatory")
	@Size(max=64, message = "Email field max size is 64")
	@Email(message = "Please enter a valid email address")
	@Column(name="email")
	private String email;
	
	@Column(name="shared_key")
	private String sharedKey;
	
	@NotBlank(message = "Phone is mandatory")
	@Size(max=32, message = "Phone field max size is 32")
	@Column(name="phone")
	private String phone;
	
	@Column(name="creation_date")
	private String creationDate;

	public String getSharedKey() {
		return sharedKey;
	}

	public void setSharedKey(String sharedKey) {
		this.sharedKey = sharedKey;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
