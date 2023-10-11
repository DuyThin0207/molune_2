package Manager;

import Product.Product;
import readAndWrite.rwProduct;


import java.util.ArrayList;
import java.util.List;

public class Manager implements IManager<Product> {
    List<Product> list;
    rwProduct rwProduct = new rwProduct();

    public Manager() {
        this.list = rwProduct.readFile();
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void delete(int id) {
        try {
            int index = findById(id);
            list.remove(index);
            rwProduct.writeFile(list);
            System.out.println("Delete thanh cong");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ko co id nay");
        }
    }

    @Override
    public Product maxPrice() {
        Product maxPrice = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > maxPrice.getPrice()) {
                maxPrice = list.get(i);
            }
        }
        return maxPrice;
    }

    @Override
    public void update(int id, Product product) {
        try {
            int index = findById(id);
            list.set(index, product);
            rwProduct.writeFile(list);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ko co id nay");
        }
    }

    @Override
    public void add(Product product) {
        list.add(product);
        rwProduct.writeFile(list);
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            try {
                if (list.get(i).getId() == id) {
                    return i;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Khong co id nay.");
            }

        }
        return -1;
    }

    @Override
    public List<Product> ascending() {
        List<Product> products = new ArrayList<>();
        Product product = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > product.getPrice()) {
                products.add(list.get(i));
            }
        }
        return products;
    }

    public void sortIncreaseProduct() {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public void sortDecreaseProduct() {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).getPrice() < list.get(j + 1).getPrice()) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
