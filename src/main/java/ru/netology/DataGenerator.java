package ru.netology;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {}
    public static class Registration {
        private Registration() {}
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
    }
}
