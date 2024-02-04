package com.bestbuykamps.websiteshop.data_model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Discount,Long> {
}
