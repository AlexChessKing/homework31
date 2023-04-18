package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    Person person = new PersonBuilder().setName("Александр").setSurname("Яковлев").setAddress("Первоуральск").build();

    @BeforeEach
    void beforeEach() {
        System.out.println("Начало теста!");
    }

    @Test
    void test_name() {
        Assertions.assertNotNull(person.name);
        System.out.println("Имя: " + person.name);
    }

    @Test
    void test_surname() {
        Assertions.assertThrows(IllegalStateException.class, () -> new PersonBuilder().setSurname("Яковлев").build());
        System.out.println("Фамилия: " + person.surname);
    }

    @Test
    void test_age() {
        Assertions.assertFalse(person.hasAge());
        System.out.println("Возраст: " + person.age);
        Assertions.assertThrows(IllegalArgumentException.class, () -> person.setAge(-100));
        person.setAge(47);
        Assertions.assertTrue(person.hasAge());
        System.out.println("Возраст: " + person.age);
    }

    @Test
    void test_childbuilder() {
        person.setAge(47);
        System.out.println(person);
        Person son = person.newChildBuilder().setName("Дмитрий").setAge(3).build();
        System.out.println(son);
        Assertions.assertEquals(person.getSurname(), son.getSurname());
        Assertions.assertEquals(person.getAddress(), son.getAddress());
    }

    @AfterEach
    void afterEach() {
        System.out.println("Тест завершен!");
    }
}
