package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не введено имя!");
        }

        if (surname == null) {
            throw new IllegalStateException("Не введена фамилия!");
        }

        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("Возраст введен некорректно!");
        }

        return new Person(name, surname, age, address);
    }
}
