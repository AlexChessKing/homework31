package ru.netology;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    protected boolean isAge;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        setAge(age);
        this.address = address;
    }

    public void setAge(int age) {
        if (hasAge()) {
            throw new IllegalStateException("Возраст уже задан!");
        }

        if (age > 0) {
            isAge = true;
            this.age = age;
        }
    }

    public boolean hasAge() {
        return age > 0;
    }

    public void happyBirthday() {
        if (isAge) {
            age++;
        }
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age + ", " + address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname). setAddress(address);
    }
}
