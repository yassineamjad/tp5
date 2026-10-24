package com.tp.service;

import com.tp.dao.IDao;
import com.tp.product.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final IDao<Product> productDao;

    public ProductServiceImpl(IDao<Product> productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public void addProduct(Product product) {
        logger.info("Validating product '{}' before insertion", product.getName());
        if (product.getPrice() < 0) {
            logger.error("Rejected product '{}' because its price is negative", product.getName());
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }
        productDao.save(product);
        logger.info("Product '{}' inserted successfully", product.getName());
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        logger.info("Requesting the complete product list");
        return productDao.findAll();
    }
}
