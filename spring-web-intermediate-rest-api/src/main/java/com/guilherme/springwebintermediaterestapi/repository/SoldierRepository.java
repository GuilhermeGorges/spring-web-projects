package com.guilherme.springwebintermediaterestapi.repository;

import com.guilherme.springwebintermediaterestapi.dto.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, Long> {
}
