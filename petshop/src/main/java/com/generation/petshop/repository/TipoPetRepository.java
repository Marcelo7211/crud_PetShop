package com.generation.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.petshop.model.TipoPet;

@Repository
public interface TipoPetRepository extends JpaRepository<TipoPet, Long> {
	
}
