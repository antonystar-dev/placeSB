package com.placeti.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.placeti.carro.model.Modelo;
@Repository

public interface ModeloRepository extends JpaRepository<Modelo, Long>{

}
