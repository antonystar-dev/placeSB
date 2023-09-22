package com.placeti.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.placeti.carro.model.Marca;
@Repository

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
