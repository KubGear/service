package com.kubgear.service.product;

import com.kubgear.domain.ProductDescription;

import java.util.List;

/**
 * todo Document type ProductDescriptionService
 */
public interface ProductDescriptionService {
    void save();
    List<ProductDescription> findAll();
}
