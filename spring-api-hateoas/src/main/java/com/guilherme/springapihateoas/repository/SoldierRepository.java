package com.guilherme.springapihateoas.repository;

import com.guilherme.springapihateoas.entity.SoldierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {
}
