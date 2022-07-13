package com.devsuperior.dsmeta.Service;

import com.devsuperior.dsmeta.Repository.SaleRepository;
import com.devsuperior.dsmeta.entidades.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(String minDate, String maxDate,Pageable pageable){

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);

        // Se for verdadeiro pegara o padrão - caso contrario ira converter para a data
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.findSales(min, max,pageable);
    }
}
