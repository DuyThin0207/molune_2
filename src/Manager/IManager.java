package Manager;

import Product.Product;

import java.util.List;

public interface IManager<E> {
    List<Product> findAll();
    void add(E e);
    void update(int id, E e);
    void delete(int id);
    Product maxPrice();
    int findById(int id);
    List<Product> ascending();
}
