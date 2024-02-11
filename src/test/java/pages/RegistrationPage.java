package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String tittleText = "Student Registration Form";
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButtons = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userBDayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBoxes = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            adressField = $("#currentAddress"),
            stateList = $("#state"),
            cityList = $("#city"),
            submitButton = $("#submit"),
            closeButton = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(tittleText));
        SelenideElement bannerRoot = $(".fc-consent-root");
        if (bannerRoot.isDisplayed()) {
            bannerRoot.$(byText("Consent")).click();
        }
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    @Step("Заполненяем имя {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Заполненяем фамилию {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Заполненяем имэйл {value}")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбираем пол {value}")
    public RegistrationPage setGender(String value) {
        genderRadioButtons.$(byText(value)).click();
        return this;
    }
    @Step("Заполненяем номер телефона {value}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Заполненяем дату рождения {day} {month} {year}")
    public RegistrationPage setBDate(String day, String month, String year) {
        userBDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Выбираем предмет {value}")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Выбираем хобби {value}")
    public RegistrationPage setHobbies(String value) {
        hobbiesCheckBoxes.$(byText(value)).click();
        return this;
    }
    @Step("Загружаем фото")
    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }
    @Step("Заполненяем номер телефона {value}")
    public RegistrationPage setAdress(String value) {
        adressField.setValue(value);
        return this;
    }
    @Step("Выбираем штат {value}")
    public RegistrationPage setState(String value) {
        stateList.click();
        stateList.$(byText(value)).click();
        return this;
    }
    @Step("Выбираем город {value}")
    public RegistrationPage setCity(String value) {
        cityList.click();
        cityList.$(byText(value)).click();
        return this;
    }
    @Step("Нажимаем кнопку Submit")
    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }
    @Step("Проверяем что модальное окно результатов появилось")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
    @Step("Проверяем что модальное окно результатов НЕ появилось")
    public RegistrationPage verifyResultsModalNotAppears() {
        registrationResultsModal.verifyModalNotAppears();
        return this;
    }
    @Step("Проверяем результаты")
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResults(key, value);
        return this;
    }
    @Step("Закрываем окно")
    public RegistrationPage clickClose() {
        closeButton.click();
        return this;
    }


}
