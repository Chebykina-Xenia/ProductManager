package ru.netology.Products;

import java.util.Objects;

public class Book extends Product {
    private String avtor;

    public Book() {
    }

    public Book(int id, String name, int price, String avtor) {
        super(id, name, price);
        this.avtor = avtor;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(avtor, book.avtor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), avtor);
    }

    @Override
    public String toString() {
        return "Book{" +
                "avtor='" + avtor + '\'' +
                '}';
    }
}
