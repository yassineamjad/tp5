package com.tp;

import com.tp.product.config.AppConfig;
import com.tp.product.entity.Product;
import com.tp.service.ProductServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        logger.info("Starting the TP5 product application");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try {
            ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);
            logger.info("Spring context initialized and ProductService retrieved");
            Product product = new Product("Microservice Gateway", 149.99);
            productService.addProduct(product);
            int total = productService.getAllProducts().size();
            logger.info("Product added successfully; total products in database: {}", total);
        } finally {
            context.close();
            logger.info("Spring context closed; application finished");
        }
    }
}