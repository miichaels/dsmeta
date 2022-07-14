package com.devsuperior.dsmeta.Controller;

import com.devsuperior.dsmeta.Repository.SaleRepository;
import com.devsuperior.dsmeta.Service.SaleService;
import com.devsuperior.dsmeta.Service.SmsService;
import com.devsuperior.dsmeta.entidades.Sale;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleRepository repository;

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    // Buscar 20 ultimas vendas
    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Sale> GetById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sale> postSale(@Validated @RequestBody Sale sale){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(sale));
    }

    @PutMapping
    public ResponseEntity<Sale> Put(@Validated @RequestBody Sale sale){
        return repository.findById(sale.getId()).map(resposta -> ResponseEntity.ok().body(repository.save(sale)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSale (@PathVariable Long id){
        return repository.findById(id).map(resposta -> {repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }).orElse(ResponseEntity.notFound().build());
    }
}