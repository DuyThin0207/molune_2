package valiDator;

import java.util.Scanner;

public class valiDatorProduct {
    public static Scanner input = new Scanner(System.in);
    public static String inputCheck(){
        String regex = "^[a-z A-Z 0-9]{1,}$";
        String name;
        do {
            name = input.nextLine();
            if (name.matches(regex)){
                break;
            }else {
                System.out.println("!! Error... Khong de trong");
            }
        }while (true);
        return name;
    }
}
