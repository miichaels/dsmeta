package com.devsuperior.dsmeta.Service;

import com.devsuperior.dsmeta.Repository.SaleRepository;
import com.devsuperior.dsmeta.entidades.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List<Sale> findSales(){
        return repository.findAll();
    }
}
