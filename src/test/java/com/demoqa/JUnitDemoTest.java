package com.demoqa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JUnitDemoTest {

    @BeforeAll
    static void setUp() {
        System.out.println("### @BeforeAll !");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("### @AfterAll !");
    }

    @BeforeEach
    void beforeEachTest() {
        // open("ya.ru");
        System.out.println("###     @BeforeEach !");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("###     @AfterEach !");
    }

    @Test
    void simpleTestFirst() {

        System.out.println("###         @Test simpleTestFirst() !");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTestSecond() {

        System.out.println("###         @Test simpleTestSecond() !");
        Assertions.assertTrue(3 > 2);
    }
}
