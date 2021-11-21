package ru.netology;

import ru.netology.Products.Book;
import ru.netology.Products.Product;
import ru.netology.Products.Smartphone;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    //добавление в репозиторий
    public void add (Product item){
        repository.save(item);
    }

    //поиск
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        Product[] products = repository.findAll();
        for(Product product :products){
        if (matches(product, text)){                 //если метод matches возвращает нам true
            Product[] tmp = new Product[result.length + 1];
            System.arraycopy(result, 0, tmp, 0, result.length);
            tmp[tmp.length - 1] = product;
            result = tmp;
        }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        Product[] result = new Product[0];
        if (product.getName().contains(search)){
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAvtor().contains(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone){
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getMaker().contains(search)){
                return true;
            }
        }
        return false;
    }
}
