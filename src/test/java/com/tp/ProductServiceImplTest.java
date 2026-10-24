package com.tp;

import com.tp.dao.IDao;
import com.tp.product.entity.Product;
import com.tp.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Test
    void addProductRejectsNegativePrices() {
        IDao<Product> dao = mock(IDao.class);
        ProductServiceImpl service = new ProductServiceImpl(dao);

        assertThrows(IllegalArgumentException.class,
                () -> service.addProduct(new Product("Invalid product", -1.0)));
        verifyNoInteractions(dao);
    }

    @Test
    void getAllProductsDelegatesToDao() {
        IDao<Product> dao = mock(IDao.class);
        when(dao.findAll()).thenReturn(List.of(new Product("Keyboard", 49.99)));
        ProductServiceImpl service = new ProductServiceImpl(dao);

        assertEquals(1, service.getAllProducts().size());
        verify(dao).findAll();
    }
}
