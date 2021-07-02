package com.generation.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.petshop.model.ClientePet;

@Repository
public interface ClientePetRepository extends JpaRepository<ClientePet, Long> {
	
}
