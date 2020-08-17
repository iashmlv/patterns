package ru.netology.web;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String getDate1(int i) {
        LocalDate dateOrder1 = LocalDate.now().plusDays(5);
        return dateOrder1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String getDate2() {
        LocalDate dateOrder2 = LocalDate.now().plusDays(7);
        return dateOrder2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static class Registration {
        private Registration() {
        }


        public static UserData generateByFaker(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String[] cities = {"Абакан", "Архангельск", "Барнаул", "Владикавказ", "Горно-Алтайск", "Екатеринбург",
                    "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Кострома", "Краснодар", "Красноярск",
                    "Курган", "Махачкала", "Москва", "Нальчик", "Петропавловск-Камчатский", "Ростов-на-Дону", "Салехард",
                    "Санкт-Петербург", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар", "Тула",
                    "Тюмень", "Чебоксары", "Южно-Сахалинск", "Ярославль"};
            Random rand = new Random();

            return new UserData(faker.name().name(),
                    faker.numerify("+7##########"),
                    cities[rand.nextInt(cities.length)]
            );
        }

        private static class Date1 {
        }
    }
}
