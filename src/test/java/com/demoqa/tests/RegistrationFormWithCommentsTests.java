package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithCommentsTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // 10 seconds
//        Configuration.browser = "opera";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Other")).click(); // best
//        $("#gender-radio-1").click(); // wrong
//        $("#gender-radio-3").parent().click(); // good
//        $(byText("Other")).click(); // not good
//        $("[for=gender-radio-3]").click(); // good
//        $(by("for", "gender-radio-3")).click(); // good
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//<div class="react-datepicker__day--030 react-datepicker__day--outside-month" >30</div>
//<div class="react-datepicker__day--030"                                      >30</div>
        $("#subjectsInput").setValue("Math").pressEnter();
//        $("#subjectsInput").sendKeys("Math");
//        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click(); // best
        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
//        File imgFile = new File("src/test/resources/img/1.png");
//        $("#uploadPicture").uploadFile(imgFile);
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive table").shouldHave(text("Alex"), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
//        $(".table-responsive table").$(byText("Date of Birth"))
//                .parent().shouldHave(text("30 July,2008"));
    }

}
