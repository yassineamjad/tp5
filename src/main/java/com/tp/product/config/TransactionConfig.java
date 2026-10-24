package com.tp.product.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {

    private static final Logger logger = LoggerFactory.getLogger(TransactionConfig.class);

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        logger.info("Registering the Hibernate transaction manager");
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}