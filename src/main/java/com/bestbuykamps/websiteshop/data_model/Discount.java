package com.bestbuykamps.websiteshop.data_model;

import jakarta.persistence.*;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_discount", nullable = false)
    private DiscountType typeOfDiscount;

    @Column(name = "discount", nullable = false)
    private Double discount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiscountType getTypeOfDiscount() {
        return typeOfDiscount;
    }

    public void setTypeOfDiscount(DiscountType typeOfDiscount) {
        this.typeOfDiscount = typeOfDiscount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}