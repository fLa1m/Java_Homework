/*Реализуйте структуру телефонной книги с помощью HashMap, 
учитывая, что 1 человек может иметь несколько телефонов. */

package Homework5;

public class task001 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Мокин Андрей Аркадьевич", "123");
        phoneBook.add("Мокин Андрей Аркадьевич", "321");
        phoneBook.add("Кузнецов Иван Иванович", "99932");
        phoneBook.add("Мельников Петр Александрович", "75633");
        phoneBook.add("Кузнецов Иван Иванович", "44432");
        phoneBook.add("Кузнецов Иван Иванович", "88746");
        phoneBook.add("Галкин Иван Петрович", "732465");

        System.out.println(phoneBook.getAllBook());
        System.out.println(phoneBook.findContact("Иван"));
    }
}
