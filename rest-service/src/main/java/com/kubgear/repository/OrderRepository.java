package com.kubgear.repository;

import com.kubgear.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * todo Document type OrderRepository
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
