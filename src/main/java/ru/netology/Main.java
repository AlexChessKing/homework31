package ru.netology;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(10)
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

//        try {
//            // не хватает обязательных полей
//            new PersonBuilder().build();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            // недопустимый возраст
//            new PersonBuilder().setAge(-100).build();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }

        mom.happyBirthday();
        System.out.println(mom);

        mom.setAddress("Мельбурн");
        System.out.println(mom);

        son.happyBirthday();
        System.out.println(son);

        mom.setAge(40);
        System.out.println(mom);
    }
}
