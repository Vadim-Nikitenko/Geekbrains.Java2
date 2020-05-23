package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strArr = {
                "счастье",
                "радость",
                "веселье",
                "гнев",
                "радость",
                "счастье",
                "презрение",
                "грусть",
                "печаль",
                "веселье"
        };

        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < strArr.length; i++) {
            String word = strArr[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Вася", "+79991112233");
        phoneBook.addContact("Маша", "+79992223344");
        phoneBook.addContact("Света", "+79993334455");
        phoneBook.addContact("Вася", "+79994445566");

        System.out.println(phoneBook.getPhoneBook());
        System.out.println(phoneBook.getInfo("Вася"));
    }
}
