package ru.netology.web;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SchedulingTest {

    String dateOrder1 = DataGenerator.getDate1(5);
    String dateOrder2 = DataGenerator.getDate2();

    @Test
    void shouldSchedule() {
        open("http://localhost:9999");
        val user = DataGenerator.Registration.generateByFaker("ru");

        $("span[data-test-id='city'] input").setValue(user.getCity().substring(0, 2));
        $$("div.menu div.menu-item").find(exactText(user.getCity())).click();

        $("span[data-test-id='date'] input.input__control").sendKeys((Keys.chord(Keys.CONTROL+"a")+Keys.DELETE));
        $("span[data-test-id='date'] input.input__control").setValue(dateOrder1);

        $("span[data-test-id='name'] input").setValue(user.getName());
        $("span[data-test-id='phone'] input").setValue(user.getPhoneNumber());

        $("label[data-test-id='agreement']").click();
        $$("button").find(exactText("Запланировать")).click();
        $("div.notification__content").waitUntil(text("Встреча успешно запланирована на " + dateOrder1),
                20000);

        $("span[data-test-id='date'] input.input__control").sendKeys(Keys.chord(Keys.COMMAND+"a")+Keys.BACK_SPACE);;
        $("span[data-test-id='date'] input.input__control").setValue(dateOrder2);

        $$("button").find(exactText("Запланировать")).click();
        $("div[data-test-id='replan-notification'] button").waitUntil(visible, 20000).click();
        $("div.notification__content").waitUntil(text("Встреча успешно запланирована на " + dateOrder2),
                20000);
    }
}
