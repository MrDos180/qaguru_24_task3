package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class StudentRegistrationFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    static Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();

    String firstName = faker.elderScrolls().firstName();
    String lastName = faker.elderScrolls().lastName();
    String email = faker.internet().emailAddress();
    String gender = genderRandom();
    String number = faker.phoneNumber().subscriberNumber(10);
    String dayBirth = String.valueOf(faker.number().numberBetween(1, 28));
    String monthBirth = monthRandom();
    String yearBirth = String.valueOf(faker.number().numberBetween(1970, 2010));
    String subject = "Math";
    String hobbie = hobbieRandom();
    String pictureDirectory = "1.jpg";
    String adress = faker.address().fullAddress();
    String city = randomUtils.cityRandom();
    String state = randomUtils.getStateByCity(city);


    @Test
    @Tag("demoqa")
    void fullSuccessfulRegistration() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender(gender).
                setUserNumber(number).
                setBDate(dayBirth, monthBirth, yearBirth).
                setSubject(subject).
                setHobbies(hobbie).
                uploadPicture(pictureDirectory).
                setAdress(adress).
                setState(state).
                setCity(city).
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", firstName + " " + lastName).
                verifyResult("Student Email", email).
                verifyResult("Gender", gender).
                verifyResult("Mobile", number).
                verifyResult("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth).
                verifyResult("Subjects", subject).
                verifyResult("Hobbies", hobbie).
                verifyResult("Picture", pictureDirectory).
                verifyResult("Address", adress).
                verifyResult("State and City", state + " " + city).
                clickClose();
    }

    @Test
    void minimalSuccessfulRegistration() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setUserNumber(number).
                setBDate(dayBirth, monthBirth, yearBirth).
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", firstName + " " + lastName).
                verifyResult("Student Email", " ").
                verifyResult("Gender", gender).
                verifyResult("Mobile", number).
                verifyResult("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth).
                verifyResult("Subjects", " ").
                verifyResult("Hobbies", " ").
                verifyResult("Picture", " ").
                verifyResult("Address", " ").
                verifyResult("State and City", " ").
                clickClose();
    }

    @Test
    void negativeRegistration() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setBDate(dayBirth, monthBirth, yearBirth).
                clickSubmit().
                verifyResultsModalNotAppears();
    }


}
