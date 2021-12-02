package ru.netology.products;

import java.util.Objects;

public class Book extends Product {
    private String author;

    public Book() {
    }

    public Book(int id, String name, int price, String avtor) {
        super(id, name, price);
        this.author = avtor;
    }

    @Override
    public boolean matches(String text) {
        return super.matches(text) || author.contains(text);
    }

    public String getAvtor() {
        return author;
    }

    public void setAvtor(String avtor) {
        this.author = avtor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "avtor='" + author + '\'' +
                '}';
    }
}
