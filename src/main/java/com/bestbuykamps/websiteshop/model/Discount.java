package com.bestbuykamps.websiteshop.model;

import jakarta.persistence.*;

@Entity
@Table(name="Discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}


/*
CREATE TABLE discount (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    typeOfDiscount ENUM('percent', 'value') NOT NULL,
    discount DOUBLE NOT NULL
);
 */