package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.Products.Product;
import ru.netology.Products.Book;
import ru.netology.Products.Smartphone;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());
    private Product first = new Product(1, "чай", 150);
    private Book second = new Book(2, "Oracle", 560, "Бэн Форта");
    private Smartphone third = new Smartphone(3, "5C", 50000, "Appel");

    @Test
    void shouldSearchByNameProduct() {
        manager.add(first);
        Product[] expected = {first};
        assertArrayEquals(expected, manager.searchBy("чай"));
    }

    @Test
    void shouldSearchByNameBook() {
        manager.add(second);
        Product[] expected = {second};
        assertArrayEquals(expected, manager.searchBy("Oracle"));
    }

    @Test
    void shouldSearchByNameSmartphone() {
        manager.add(third);
        Product[] expected = {third};
        assertArrayEquals(expected, manager.searchBy("5C"));
    }

    @Test
    void shouldSearchByAvtorBook() {
        manager.add(second);
        Product[] expected = {second};
        assertArrayEquals(expected, manager.searchBy("Бэн Форта"));
    }

    @Test
    void shouldSearchByMakerSmartphone() {
        manager.add(third);
        Product[] expected = {third};
        assertArrayEquals(expected, manager.searchBy("Appel"));
    }

    @Test
    void shouldSearchByFalse() {
        manager.add(first);
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Test");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNoSearchByAvtorBook() {
        manager.add(second);
        Product[] expected = new Product[0];
        assertArrayEquals(expected, manager.searchBy("Барто"));
    }

    @Test
    void shouldNoSearchByMakerSmartphone() {
        manager.add(third);
        Product[] expected = new Product[0];
        assertArrayEquals(expected, manager.searchBy("Nokia"));
    }

}