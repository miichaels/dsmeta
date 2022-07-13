package com.devsuperior.dsmeta.Repository;

import com.devsuperior.dsmeta.entidades.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
