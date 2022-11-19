package com.api.semanatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.semanatec.model.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
}
