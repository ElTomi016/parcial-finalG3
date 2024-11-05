package org.fis.inventorymanagement;
import org.fis.inventorymanagement.models.Product;
import org.fis.inventorymanagement.models.Sale;
import org.fis.inventorymanagement.services.ProductService;
import org.fis.inventorymanagement.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTests {
    
    private Product productsService;

    @BeforeEach
    void setUp() {
        productsService = new ProductService();
    }

    @Test
    void testCreateSale() {
        Sale saleDTO = new Sale( 4,4, 10, 100.0, "2021-05-04");
        Sale sale = productsService.createSale(saleDTO);
        assertNotNull(sale);
        assertEquals(4, sale.getProductId());
        assertEquals(10, sale.getQuantity());
        assertEquals(100.0, sale.getPrice());
        assertEquals("2021-05-04", sale.getDate());
    }

    @Test
    void testGetAllSales() {
        List<Sale> sales = productsService.getAllSales();
        assertNotNull(sales);
        assertEquals(3, sales.size());
    }

    @Test
    void testGetSaleById() {
        Sale sale = productsService.getProductById(1);
        assertNotNull(sale);
        assertEquals(1, sale.getId());
    }

    @Test
    void testUpdateSale() {
        Sale sale = productsService.getProductById(1);

        sale.setQuantity(15);
        sale.setPrice(150.0);
        sale.setDate("2021-05-05");

        Product updatedSale = productsService.updateproduct(1, productsService);

        assertNotNull(updatedSale);
        assertEquals(1, updatedSale.getProductId());
        assertEquals(15, updatedSale.getQuantity());
        assertEquals(150.0, updatedSale.getPrice());
        assertEquals("2021-05-05", updatedSale.getDate());
    }

    @Test
    void testDeleteSale() {
        productsService.deleteproduct(1);
        Product product = productsService.getProductById(1);
        assertNull(sale);
    }
}
