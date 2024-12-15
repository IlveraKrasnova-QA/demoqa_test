import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormJUnitTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationFormJUnitTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("kotechka");
        $("[id=lastName]").setValue("kotova");
        $("[id=userEmail]").setValue("k@kt.com");
        $("[for=gender-radio-2]").click();
        $("[id=userNumber]").setValue("0001111213");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption("February");
        $("[class=react-datepicker__year-select]").selectOption("1999");
        $("[class~=react-datepicker__day--002").click();
        $("[for=hobbies-checkbox-3]").click();
        $("[id=subjectsInput]").setValue("Arts").pressEnter();
        $("[id=uploadPicture]").uploadFromClasspath("photo_2024-11-25 16.43.04.jpg");
        $("[id=currentAddress]").setValue("Moscow");
        $("[id=state]").click();
        $("[id=react-select-3-input]").setValue("ncr").pressEnter();
        $("[id=city]").click();
        $("[id=react-select-4-input]").setValue("noi").pressEnter();
        $("[id=submit]").click();

        $("[class=table-responsive]").shouldHave(text("kotechka kotova"));
        $("[class=table-responsive]").shouldHave(text("k@kt.com"));
        $("[class=table-responsive]").shouldHave(text("Female"));
        $("[class=table-responsive]").shouldHave(text("0001111213"));
        $("[class=table-responsive]").shouldHave(text("02 February,1999"));
        $("[class=table-responsive]").shouldHave(text("Arts"));
        $("[class=table-responsive]").shouldHave(text("Music"));
        $("[class=table-responsive]").shouldHave(text("photo_2024-11-25 16.43.04.jpg"));
        $("[class=table-responsive]").shouldHave(text("Moscow"));
        $("[class=table-responsive]").shouldHave(text("NCR Noida"));
        $("[id=closeLargeModal]").click();
    }
}