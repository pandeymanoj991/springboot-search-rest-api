package com.mktech.springboot.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mktech.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//Using JPQL
	@Query("Select p from Product p where"
			+ " p.name like concat('%',:query,'%)"
			+ " or p.description like concat('%',:query,'%' ")
	List<Product> searchProducts(String query);
	
	
	//Netive query
	@Query(value = "Select * from products p where"
			+ " p.name like concat('%',:query,'%)"
			+ " or p.description like concat('%',:query,'%' )" ,nativeQuery = true)
	List<Product> searchProductSQL(String query);

}
