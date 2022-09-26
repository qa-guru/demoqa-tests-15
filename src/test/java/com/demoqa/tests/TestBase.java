package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    String firstName = "Alex",
            lastName = "Egorov",
            email = "alex@egorov.com",
            phone = "1234567890",
            day = "30",
            month = "July",
            year = "2008";

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
