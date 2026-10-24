package com.tp.dao;

import com.tp.product.entity.Product;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDaoImpl implements IDao<Product> {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        logger.info("Saving product '{}'", product.getName());
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void update(Product product) {
        logger.info("Updating product with id {}", product.getId());
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(Product product) {
        logger.info("Deleting product with id {}", product.getId());
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public Product findById(Long id) {
        logger.info("Finding product with id {}", id);
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        logger.info("Loading all products");
        return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).list();
    }
}