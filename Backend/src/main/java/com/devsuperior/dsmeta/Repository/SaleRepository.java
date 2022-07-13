package com.devsuperior.dsmeta.Repository;

import com.devsuperior.dsmeta.entidades.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.time.LocalDate;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    //Seleciona todos os objetos, onde o objeto esteja entre a data min e max, ordena de forma decrescente
    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}