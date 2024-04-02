package com.riya.Ecomerce.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="cart")
public class Cart implements Serializable {

    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // creating one to one relationship
    @OneToOne
    private User user;


    @Column(name = "grand_total")
    private double grandTotal;

    @Column(name = "cart_lines")
    private int cartLines;


}
