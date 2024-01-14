package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"))
                .shouldBe(Condition.visible);
    }
    public void verifyModalNotAppears() {
        $("#example-modal-sizes-title-lg")
                .shouldBe(Condition.not(visible));
    }

    public void verifyResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
    public void checkTextBoxResult(String key, String value) {
        $("#output").shouldHave(text(key)).shouldHave(text(value));
    }
}
