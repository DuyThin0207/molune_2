package Main;

import Menu.Menu;
import readAndWrite.rwProduct;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenuProduct();
        rwProduct rw = new rwProduct();
        rw.readFile();
    }
}
