package com.demoqa;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("a@a.com");
        $(by("data-testid", "email")).setValue("a@a.com");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("a@a.com");
        $("#email").setValue("a@a.com");
        $(byId("email")).setValue("a@a.com");
        $(By.id("email")).setValue("a@a.com");
        $x("//*[@id='email']").setValue("a@a.com");
        $(By.xpath("//*[@id='email']")).setValue("a@a.com");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("a@a.com");
        $(byName("email")).setValue("a@a.com");

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("a@a.com");
        $(".login_form_input_box").setValue("a@a.com");
        $(".inputtext.login_form_input_box").setValue("a@a.com");
        $("input.inputtext.login_form_input_box").setValue("a@a.com");
        $x("//input[@class='login_form_input_box']").setValue("a@a.com");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("a@a.com");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue("a@a.com");
        $(".inputtext").$(".login_form_input_box").setValue("a@a.com");

        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $x("//div[contains(text(), 'llo qa.gur')]");
        $x("//div[text()[contains(., 'llo qa.gur')]]");
        $(byText("Hello qa.guru"));
        $(withText("llo qa.gur"));
    }
}
