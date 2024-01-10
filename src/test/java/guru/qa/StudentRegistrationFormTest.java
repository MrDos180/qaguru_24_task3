package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("5555555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#currentAddress").setValue("Russia,Moscow, Lenin st.1");
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table").shouldHave(text("Alex Ivanov"));
        $(".table").shouldHave(text("ivanov@mail.com"));
        $(".table").shouldHave(text("5555555555"));
        $(".table").shouldHave(text("15 January,1988"));
        $(".table").shouldHave(text("Maths"));
        $(".table").shouldHave(text("Music"));
        $(".table").shouldHave(text("1.jpg"));
        $(".table").shouldHave(text("Russia,Moscow, Lenin st.1"));
        $(".table").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();






    }
}
