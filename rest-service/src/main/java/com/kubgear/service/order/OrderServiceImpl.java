package com.kubgear.service.order;

import com.kubgear.domain.Order;
import com.kubgear.domain.OrderDetails;
import com.kubgear.domain.ProductDescription;
import com.kubgear.repository.OrderDetailsRepository;
import com.kubgear.repository.OrderRepository;
import com.kubgear.repository.ProductDescriptionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * todo Document type OrderServiceImpl
 */
@Service
@AllArgsConstructor
@Log
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderDetailsRepository orderDetailsRepository;
    private ProductDescriptionRepository productDescriptionRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
