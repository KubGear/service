package org.jibx.test;

import java.util.ArrayList;

public class Product {

    protected ArrayList productList = new ArrayList();

    public void addProduct(ProductType product) {
        productList.add(product);
    }

    public ProductType getProduct(int index) {
        return (ProductType) productList.get(index);
    }
    public int productSize(){
        return this.productList.size();
    }
}