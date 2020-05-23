package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public Map<String, ArrayList<String>> getPhoneBook() {
        return phoneBook;
    }

    public void addContact(String name, String phone) {
        ArrayList<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public ArrayList<String> getPhonesByName(String name) {
        return phoneBook.get(name);
    }

    public String getInfo(String name) {
        String result = "Контакт: " + name + "\nТелефоны: " + getPhonesByName(name);
        return result.replaceAll("[\\[\\]]", "");
    }

}
