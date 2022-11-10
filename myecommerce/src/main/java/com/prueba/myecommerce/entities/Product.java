package com.prueba.myecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "{NotEmpty.Videojuego.titulo}")
    private String name;

    @Size(min=5,max=100,message= "La descripción debe ser entre 5 y 100 caracteres")
    private String description;

    @Min(value = 5,message="El precio debe tener un minimo de 1")
    @Max(value = 10000, message="El precio debe ser menor a 10000")
    private float price;

    @Min(value = 1,message="El stock debe tener un minimo de 1")
    @Max(value = 100, message="El stock debe ser menor a 100")
    private short stock;

}
