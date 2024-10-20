package org.sid.bilingservice.model;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String nom;
    private double price;
    private int quantity;
}
