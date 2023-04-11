package com.eoi.Facturacion.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invoice {
    @Id
    private Integer id;
    private String nombre;

}

