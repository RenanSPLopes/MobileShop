package com.renan.mobileshop.Persistency;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.renan.mobileshop.Models.Product;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Insert
    void insert(Product product);


   /* public List<Product> getProducts(){

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

        Product product4 = new Product();
        product4.setName("Smartphone Motorola Moto G6 Plus Dual Chip Android Oreo - 8.0 Tela 5.9\" Octa-Core 2.2 GHz 64GB 4G Câmera 12 + 5MP (Dual Traseira) - Índigo");
        product4.setPrice(1699.99);
        product4.setImageId(4);

        Product product5 = new Product();
        product5.setName("Smartphone Samsung Galaxy S9 - Preto + Smartphone Samsung Galaxy A8+ - Preto");
        product5.setPrice(5498.49);
        product5.setImageId(5);

        Product product6 = new Product();
        product6.setName("Smartphone Samsung Galaxy J7 Prime Dual Chip Android 6.0 Tela 5.5\" Octa- Core 1.6 GHz 32GB 4G Câmera 13MP - Rosa");
        product6.setPrice(922.49);
        product6.setImageId(6);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);

        return products;
    }*/
}
