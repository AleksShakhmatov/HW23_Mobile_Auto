package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {
    @Test
    @Tag("mobile")
    void openSearchResultTest() {
        step("Type search", () -> {
                    $(accessibilityId("Search Wikipedia")).click();
                    $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("moto");
        });

        step("Verify content found", () ->{
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));
        });

        step("Verify needed content found", () -> {
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .first().shouldHave(text("moto"));
        });

        step("Open founded content", () -> {
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .first().click();
        });
        step("Verify open content page", () -> {
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                .shouldHave(text("An error occurred"));
        });
    }
}