package com.kubgear.service.product;

import com.kubgear.domain.ProductDescription;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.jibx.test.JibxService;
import org.jibx.test.Product;
import org.springframework.stereotype.Service;
import com.kubgear.repository.ProductDescriptionRepository;

import java.util.List;

/**
 * todo Document type ProductDescriptionImpl
 */
@Service
@AllArgsConstructor
@Log
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    private ProductDescriptionRepository productDescriptionRepository;
    @Override
    public void save() {
        Product product = (Product) JibxService.getProduct();
        for (int i = 0; i< product.productSize(); i++){
            ProductDescription productDescription = new ProductDescription();
            productDescription.setName(product.getProduct(i).getName());
            productDescription.setSerialNumber(product.getProduct(i).getSerialNumber());
            productDescription.setDescription(product.getProduct(i).getDescription());
            productDescription.setCreateDate(product.getProduct(i).getCreateDate());

            productDescriptionRepository.save(productDescription);
        }
    }

    @Override
    public List<ProductDescription> findAll() {
        return productDescriptionRepository.findAll();
    }
}

