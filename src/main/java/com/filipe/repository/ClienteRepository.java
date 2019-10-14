package com.filipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
