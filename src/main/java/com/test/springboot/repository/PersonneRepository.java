package com.test.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.test.springboot.models.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

	
	
}
