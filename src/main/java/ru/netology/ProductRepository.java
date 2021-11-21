package ru.netology;
import ru.netology.Products.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    //сохраняем продукты
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //выводим все продукты
    public Product[] findAll() {
        return items;
    }

    //удаляем по id
    public void removeById(int id) {
        int lenght = items.length - 1;
        Product[] tmp = new Product[lenght];
        int index = 0;
        for (Product item : items){
            if (item.getId() != id){
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
