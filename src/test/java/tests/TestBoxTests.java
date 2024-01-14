package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TestBoxTests extends TestBase{
    TextBoxPage textBoxPage= new TextBoxPage();

    String fullName = "Alex Ivanov";
    String email = "ivanov@mail.com";
    String address = "Moscow, lenina st 25";
    String permanentAddress = "Moscow, lenina st 25";


    @Test
    void successfulTestBoxTest() {
        textBoxPage.openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(address)
                .setPermanentAddress(permanentAddress)
                .pressSubmit();

        textBoxPage.checkTextBoxResult("Name","Alex Ivanov")
                .checkTextBoxResult("Email","ivanov@mail.com")
                .checkTextBoxResult("Current Address","Moscow, lenina st 25")
                .checkTextBoxResult("Permananet Address","Moscow, lenina st 25");
    }

}
