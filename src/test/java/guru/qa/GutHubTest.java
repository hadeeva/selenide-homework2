package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GutHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void successfulEnterprisePageOpen() {


        open("https://github.com/");
        $$(".HeaderMenu-link").filterBy(text("solutions")).first().hover();
        $("[href='/enterprise']").click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform"));


    }
}