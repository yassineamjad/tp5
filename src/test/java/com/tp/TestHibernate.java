package com.tp;


import com.tp.product.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHibernate {
    private static final Logger logger = LoggerFactory.getLogger(TestHibernate.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try {
            logger.info("Spring context initialized successfully");
        } finally {
            context.close();
            logger.info("Spring context closed successfully");
        }
    }
}