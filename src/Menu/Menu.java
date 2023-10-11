package Menu;

import Manager.Manager;
import Product.Product;
import org.w3c.dom.ls.LSOutput;
import valiDator.valiDatorProduct;

import java.util.Scanner;

public class Menu {
    Manager manager = new Manager();
    Scanner inputStr = new Scanner(System.in);
    Scanner inputNum = new Scanner(System.in);

    public void showMenuProduct() {
        int choice;
        do {
            System.out.println("===Menu===");
            System.out.println("1: Xem danh sách\n2: Thêm mới\n3: Cập nhật\n4: Xóa\n5: Sắp xếp\n6: Sản phẩm giá đắt nhất\n0: OUT");
            choice = inputNumber();
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    showAdd();
                    break;
                case 3:
                    showUpdate();
                    break;
                case 4:
                    showDelete();
                    break;
                case 5:
                    showAscending();
                    break;
                case 6:
                    showMaxPrice();
                    break;
            }
        } while (choice != 0);
    }

    public int inputNumber() {
        Scanner inputNum = new Scanner(System.in);
        int number;
        do {
            try {
                number = Integer.parseInt(inputNum.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("----Yêu cầu chỉ nhập số----");
            }
        } while (true);
        return number;
    }

    public void showAll() {
        System.out.println(manager.findAll());
    }

    public void showAdd() {
        System.out.println("----Thêm mới sản phẩm----");
        System.out.println("ID:");
        int id = inputNumber();
        System.out.println("Name:");
        String name = valiDatorProduct.inputCheck();
        System.out.println("Price:");
        int price = inputNumber();
        System.out.println("Quantity:");
        int quantity = inputNumber();
        System.out.println("Describe");
        String describe = valiDatorProduct.inputCheck();
        Product product = new Product(id, name, price, quantity, describe);
        manager.add(product);
    }

    public void showUpdate() {
        System.out.println("Nhập id muốn sửa:");
        int checkId = inputNumber();
        System.out.println("Name:");
        String name = valiDatorProduct.inputCheck();
        System.out.println("Price:");
        int price = inputNumber();
        System.out.println("Quantity:");
        int quantity = inputNumber();
        System.out.println("Describe");
        String describe = valiDatorProduct.inputCheck();
        Product product = new Product(checkId, name, price, quantity, describe);
        manager.update(checkId, product);

    }

    public void showDelete() {
        System.out.println("Nhập ID sản phẩm muốn xóa:");
        int checkId = inputNumber();
        manager.delete(checkId);
    }

    public void showMaxPrice() {
        System.out.println(manager.maxPrice());
    }

    public void showAscending() {
        int choice;
        do {
            System.out.println("1: Tang dan\n2: Giam dan\n0: OUT");
            choice = inputNumber();
            switch (choice) {
                case 1:
                    manager.sortIncreaseProduct();
                    break;
                case 2:
                    manager.sortDecreaseProduct();
                    break;
            }
        } while (choice != 0);
    }
}
