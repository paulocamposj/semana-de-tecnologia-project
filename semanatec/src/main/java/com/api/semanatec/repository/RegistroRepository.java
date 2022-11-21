package com.api.semanatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.semanatec.model.entities.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

}
