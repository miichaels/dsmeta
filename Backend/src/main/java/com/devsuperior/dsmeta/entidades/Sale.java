package com.devsuperior.dsmeta.entidades;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "tb_sales")
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do vendedor
    private String sellerName;

    // Visitas
    private int visited;

    // Vendas
    private int deals;

    // Valor
    private Double amount;

    // Data
    private LocalDate date;

    // Metodo
    public Sale(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public int getDeals() {
        return deals;
    }

    public void setDeals(int deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}