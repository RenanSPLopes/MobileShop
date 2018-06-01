package com.renan.mobileshop.Repository;

import com.renan.mobileshop.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public List<Product> getProducts(){

        Product product = new Product();
        product.setName("Iphone 7 Jet Black 32GB Preto Iphone IOS 4G Wi-fi Câmera 12MP");
        product.setPrice(2748.98);
        product.setImageId(1);

        Product product2 = new Product();
        product2.setName("IPhone 8 Plus 64GB Vermelho Special Edition Tela 5.5 IOS 11 4G Câmera 12MP");
        product2.setPrice(3999.99);
        product2.setImageId(2);

        Product product3 = new Product();
        product3.setName("Samsung Galaxy S8 Dual Chip Android 7.0 Tela 5.8\" Octa-Core 2.3GHz 64GB 4G Câmera 12MP - Preto");
        product3.setPrice(2799.99);
        product3.setImageId(3);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        return products;
    }
}
