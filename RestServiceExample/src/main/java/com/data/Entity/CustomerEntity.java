package com.data.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="customerEntity")
	List<AddressEntity> addressEntities;
	
	
	public CustomerEntity() {
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
	
	public List<AddressEntity> getAddressEntities() {
		return addressEntities;
	}
	
	public void setAddressEntities(List<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
