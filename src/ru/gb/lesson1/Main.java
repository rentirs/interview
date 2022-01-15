package ru.gb.lesson1;

public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .address("Адрес")
                .age(40)
                .country("Страна")
                .gender("Пол")
                .firstName("Имя")
                .middleName("Отчество")
                .lastName("Фамилия")
                .phone("Телефон")
                .build();
        System.out.println(person);
    }
}
