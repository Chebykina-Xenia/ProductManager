package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.products.Product;
import ru.netology.products.Book;
import ru.netology.products.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());
    private Product first = new Product(1, "чай", 150);
    private Book second = new Book(2, "Oracle", 560, "Бэн Форта");
    private Smartphone third = new Smartphone(3, "5C", 50000, "Appel");
    private Product fourth = new Product(4, "чай", 300);

    @Test
    void shouldSearchByNameProduct() {
        manager.add(first);
        Product[] expected = {first};
        assertArrayEquals(expected, manager.searchBy("чай"));
    }

    //несколько товаров подходит под поиск
    @Test
    void shouldSearchByNameProducts() {
        manager.add(first);
        manager.add(fourth);
        Product[] expected = {first, fourth};
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
    void shouldSearchByAuthorBook() {
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
    void shouldNoSearchByAuthorBook() {
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

    @Test
    void matchesFalseProduct() {
        boolean expected = false;
        assertEquals(expected, first.matches("конфеты"));
    }

    @Test
    void matchesTrueProduct() {
        boolean expected = true;
        assertEquals(expected, first.matches("чай"));
    }

    @Test
    void matchesFalseBook() {
        boolean expected = false;
        assertEquals(expected, second.matches("Агния Барто"));
    }

    @Test
    void matchesTrueBook() {
        boolean expected = true;
        assertEquals(expected, second.matches("Бэн Форта"));
    }

    @Test
    void matchesTrueSmartphone() {
        boolean expected = true;
        assertEquals(expected, third.matches("Appel"));
    }

    @Test
    void matchesFalseSmartphone() {
        boolean expected = false;
        assertEquals(expected, third.matches("Nokia"));
    }

}