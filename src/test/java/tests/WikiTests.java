package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;


public class WikiTests1 extends TestBase1 {
    @Test
    @DisplayName("Display search result")
    void successfulSearchMotoTest() {
        step("Нажать на skip, выйти из онбординка", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar")).shouldBe(visible);
        });

        step(" Нажать на поиск и ввести значениe ", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("moto");
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).get(0).click();
        });


        step("Проверить текст подзаголовка", () -> {
            $$(className("android.widget.TextView"))
                    .get(1)
                    .shouldHave(text("Topics referred to by the same term"));
        });

    }
}