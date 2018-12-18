package com.rest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.data.Entity.CustomerEntity;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Long> {
	
//	    @Query("SELECT * FROM Customer WHERE name= (:name)")
//	    List<CustomerEntity> findByName(@Param("name") String name);
	    List<CustomerEntity> findByName(String name);

}
